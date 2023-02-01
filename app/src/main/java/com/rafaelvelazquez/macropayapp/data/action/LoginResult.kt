package com.rafaelvelazquez.macropayapp.data.action

import com.rafaelvelazquez.macropayapp.data.domain.DashboardDomainModel

sealed class LoginResult {
    data class Success(val domainModel: DashboardDomainModel) : LoginResult()
}