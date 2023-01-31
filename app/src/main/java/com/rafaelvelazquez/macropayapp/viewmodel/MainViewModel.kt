package com.rafaelvelazquez.macropayapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rafaelvelazquez.macropayapp.data.action.LoginAction
import com.rafaelvelazquez.macropayapp.data.remote.LoginRequest
import com.rafaelvelazquez.macropayapp.repository.AppRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: AppRepository
) : AppBaseViewModel() {

    private val _action = MutableLiveData<LoginAction>()

    fun getLoginAction() = _action as LiveData<LoginAction>

    fun loginUser(user: RequestBody, password:RequestBody) {
        disposable.add(
            repository.loginUser(
                user,
                password
            )
                .doOnSubscribe { showProgress.value = true }
                .doFinally { showProgress.value = false }
                .subscribe(
                    {
                        _action.value = LoginAction.Success(it)
                    },
                    {
                        showError.value = it
                    }
                )
        )
    }

}