package com.rafaelvelazquez.macropayapp.retrofit

import com.rafaelvelazquez.macropayapp.data.remote.LoginResponse
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.*

interface RestServiceApi {

    @Multipart
    @POST("/")
    fun loginUSer(
        @Part("email") email: RequestBody,
        @Part("password") passwordB: RequestBody
    ): Single<LoginResponse>
}