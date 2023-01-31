package com.rafaelvelazquez.macropayapp.repository

import com.rafaelvelazquez.macropayapp.retrofit.RestServiceApi
import dagger.Reusable
import javax.inject.Inject

@Reusable
class AppRepository @Inject constructor(
    private var restServiceApi: RestServiceApi
) {

    fun imprimeRepository() {

    }
}