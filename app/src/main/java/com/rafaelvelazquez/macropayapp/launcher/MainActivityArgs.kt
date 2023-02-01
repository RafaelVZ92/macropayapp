package com.rafaelvelazquez.macropayapp.launcher

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import com.rafaelvelazquez.macropayapp.data.remote.DashboardResponse
import com.rafaelvelazquez.macropayapp.ui.activity.MainActivity
import com.rafaelvelazquez.macropayapp.utils.ActivityLauncher
import kotlinx.parcelize.Parcelize

@Parcelize
class MainActivityArgs(
    val dashboardData: DashboardResponse
) : ActivityLauncher, Parcelable {

    override fun intent(context: Context) =
        Intent(context, MainActivity::class.java).apply {
            putExtra(EXTRAS, this@MainActivityArgs)
        }

    companion object {
        const val EXTRAS = "EXTRAS"
    }

}