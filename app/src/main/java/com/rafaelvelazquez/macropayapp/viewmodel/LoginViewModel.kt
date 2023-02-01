package com.rafaelvelazquez.macropayapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.rafaelvelazquez.macropayapp.data.action.LoginResult
import com.rafaelvelazquez.macropayapp.data.remote.DashboardResponse
import com.rafaelvelazquez.macropayapp.repository.LoginRepository
import okhttp3.RequestBody
import java.util.*
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : AppBaseViewModel() {

    private val _loginResult = MutableLiveData<LoginResult>()
    fun getLoginResul(): LiveData<LoginResult> = _loginResult


    fun loginUser(user: RequestBody, password: RequestBody) {
        disposable.add(
            loginRepository.loginUser(
                user,
                password
            )
                .doOnSubscribe { showProgress.value = true }
                .doFinally { showProgress.value = false }
                .subscribe(
                    {
                        _loginResult.value = LoginResult.Success(
                            handleDashboardData(it.token)
                        )
                    },
                    {
                        showError.value = it.message
                    }
                )
        )
    }


    private fun handleDashboardData(token: String): DashboardResponse {
        val gson = Gson()
        val mDecode = decodeToken(token)
        return gson.fromJson(mDecode, DashboardResponse::class.java)
    }

    private fun decodeToken(jwt: String): String {
        val parts = jwt.split(".")
        return try {
            val charset = charset("UTF-8")
            val header = String(Base64.getUrlDecoder().decode(parts[0].toByteArray(charset)), charset)
            val payload = String(Base64.getUrlDecoder().decode(parts[1].toByteArray(charset)), charset)
            header
            payload
        } catch (e: Exception) {
            "Error parsing JWT: $e"
        }
    }
}