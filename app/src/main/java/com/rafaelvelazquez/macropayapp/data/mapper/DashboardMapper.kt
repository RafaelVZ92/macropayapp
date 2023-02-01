package com.rafaelvelazquez.macropayapp.data.mapper

import com.google.gson.Gson
import com.rafaelvelazquez.macropayapp.data.domain.DashboardDomainModel
import com.rafaelvelazquez.macropayapp.data.remote.DashboardResponse
import com.rafaelvelazquez.macropayapp.data.remote.LoginResponse
import java.util.*
import javax.inject.Inject

class DashboardMapper @Inject constructor() : Mapper<LoginResponse, DashboardDomainModel> {

    private lateinit var domainModel: DashboardDomainModel

    override fun map(input: LoginResponse): DashboardDomainModel {
        if (input.success){
            domainModel = mapDashboardDomainModel(input.token)
        } else {
            throw IllegalArgumentException(
                "Credenciales nullas o invalidas"
            )
        }
        return domainModel
    }

    private fun mapDashboardDomainModel(token: String) =
        DashboardDomainModel(
            handleDashboardData(token).titular,
            token,
            decodeToken(token)
        )

    private fun handleDashboardData(token: String): DashboardResponse {
        val gson = Gson()
        val mDecode = decodeToken(token)
        return gson.fromJson(mDecode, DashboardResponse::class.java)
    }

    private fun decodeToken(jwt: String): String {
        val parts = jwt.split(".")
        return try {
            val charset = charset("UTF-8")
            val payload = String(Base64.getUrlDecoder().decode(parts[1].toByteArray(charset)), charset)
            payload
        } catch (e: Exception) {
            throw IllegalArgumentException(
                "Error parsing JWT: $e"
            )
        }
    }

}