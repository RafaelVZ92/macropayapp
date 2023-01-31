package com.rafaelvelazquez.macropayapp.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafaelvelazquez.macropayapp.R
import com.rafaelvelazquez.macropayapp.di.injector
import com.rafaelvelazquez.macropayapp.utils.viewModel
import com.rafaelvelazquez.macropayapp.viewmodel.MainViewModel
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel {
        injector.mainViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login(
            "admin@macropay.mx",
            "Admin1"
        )
    }

    fun login(email: String, password: String) {
            var userNameB:RequestBody=
                email.toRequestBody(email.toMediaTypeOrNull())
            var passwordB: RequestBody =
                password.toRequestBody(password.toMediaTypeOrNull())
        viewModel.loginUser(
            userNameB,
            passwordB
        )
    }

}