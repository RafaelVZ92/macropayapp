package com.rafaelvelazquez.macropayapp.data.action

import com.rafaelvelazquez.macropayapp.data.remote.LoginResponse

sealed class LoginResult {
    data class Success(val response: LoginResponse) : LoginResult()
}