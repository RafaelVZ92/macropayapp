package com.rafaelvelazquez.macropayapp.data.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DashboardResponse(
    @SerializedName("email")
    val email: String,
    @SerializedName("solicitud")
    val solicitud: String,
    @SerializedName("titular")
    val titular: String,
    @SerializedName("url")
    val url: String
): Parcelable