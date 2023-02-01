package com.rafaelvelazquez.macropayapp.launcher

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import com.rafaelvelazquez.macropayapp.data.domain.DashboardDomainModel
import com.rafaelvelazquez.macropayapp.ui.activity.MainActivity
import com.rafaelvelazquez.macropayapp.utils.ActivityLauncher
import kotlinx.parcelize.Parcelize

@Parcelize
class MainActivityArgs(
    val dashboardData: DashboardDomainModel
) : ActivityLauncher, Parcelable {

    override fun intent(context: Context) =
        Intent(context, MainActivity::class.java).apply {
            putExtra(EXTRAS, this@MainActivityArgs)
        }

    companion object {
        const val EXTRAS = "EXTRAS"
    }

}