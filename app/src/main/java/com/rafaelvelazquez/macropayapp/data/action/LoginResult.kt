package com.rafaelvelazquez.macropayapp.data.action

import com.rafaelvelazquez.macropayapp.data.remote.DashboardResponse

sealed class LoginResult {
    data class Success(val response: DashboardResponse) : LoginResult()
}