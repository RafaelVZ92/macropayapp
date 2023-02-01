package com.rafaelvelazquez.macropayapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Patterns
import com.rafaelvelazquez.macropayapp.data.action.LoginResult
import com.rafaelvelazquez.macropayapp.repository.LoginRepository
import okhttp3.RequestBody
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
                        _loginResult.value = LoginResult.Success(it)
                    },
                    {
                        showError.value = it.message
                    }
                )
        )
    }
}