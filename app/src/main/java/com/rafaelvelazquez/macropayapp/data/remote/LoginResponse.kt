package com.rafaelvelazquez.macropayapp.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginResponse(
    val success: Boolean,
    val token: String
): Parcelable