package com.rafaelvelazquez.macropayapp.retrofit

import com.rafaelvelazquez.macropayapp.data.remote.LoginRequest
import com.rafaelvelazquez.macropayapp.data.remote.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestServiceApi {

    @Headers("Content-Type: application/json")
    @POST
    fun loginApp(
        @Body loginRequest: LoginRequest
    ): Single<LoginResponse>
}