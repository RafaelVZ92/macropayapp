package com.rafaelvelazquez.macropayapp.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DashboardResponse(
    val email: String,
    val solicitud: String,
    val titular: String,
    val url: String
): Parcelable