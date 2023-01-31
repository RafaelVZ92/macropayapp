package com.rafaelvelazquez.macropayapp.repository

import com.rafaelvelazquez.macropayapp.data.remote.LoginResponse
import com.rafaelvelazquez.macropayapp.retrofit.RestServiceApi
import com.rafaelvelazquez.macropayapp.utils.applySchedulers
import dagger.Reusable
import io.reactivex.Single
import okhttp3.RequestBody
import javax.inject.Inject

@Reusable
class AppRepository @Inject constructor(
    private var restServiceApi: RestServiceApi
) {

    fun loginUser(
        user: RequestBody,
        password: RequestBody
    ): Single<LoginResponse> {
        return restServiceApi.loginUSer(
            user,
            password
        ).applySchedulers()
    }
}