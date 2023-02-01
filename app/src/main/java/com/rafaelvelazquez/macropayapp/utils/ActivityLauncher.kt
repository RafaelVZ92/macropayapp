package com.rafaelvelazquez.macropayapp.utils

import android.content.Context
import android.content.Intent

interface ActivityLauncher {

    fun intent(context: Context): Intent
}
