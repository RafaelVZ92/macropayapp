package com.rafaelvelazquez.macropayapp.data.action

import com.rafaelvelazquez.macropayapp.data.remote.LoginResponse

sealed class LoginAction {
    data class Success(val response: LoginResponse) : LoginAction()
}