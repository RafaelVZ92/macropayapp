package com.rafaelvelazquez.macropayapp.data.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DashboardDomainModel(
    val titular: String,
    val token: String
): Parcelable