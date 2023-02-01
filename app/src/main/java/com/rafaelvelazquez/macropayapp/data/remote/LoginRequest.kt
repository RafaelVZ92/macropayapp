package com.rafaelvelazquez.macropayapp.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class LoginRequest(
    val email: String,
    val password: String
): Parcelable