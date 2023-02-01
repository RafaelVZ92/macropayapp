package com.rafaelvelazquez.macropayapp.repository

import com.rafaelvelazquez.macropayapp.data.domain.DashboardDomainModel
import com.rafaelvelazquez.macropayapp.data.mapper.DashboardMapper
import com.rafaelvelazquez.macropayapp.retrofit.RestServiceApi
import com.rafaelvelazquez.macropayapp.utils.applySchedulers
import dagger.Reusable
import io.reactivex.Single
import okhttp3.RequestBody
import javax.inject.Inject

@Reusable
class LoginRepository @Inject constructor(
    private val restServiceApi: RestServiceApi,
    private val mapper: DashboardMapper
) {

    fun loginUser(
        user: RequestBody,
        password: RequestBody
    ): Single<DashboardDomainModel> {
        return restServiceApi.loginUSer(
            user,
            password
        ).map { response ->
            mapper.map(response)
        }.applySchedulers()
    }
}