package com.rafaelvelazquez.macropayapp.ui.activity

import androidx.lifecycle.Observer
import android.os.Bundle
import com.rafaelvelazquez.macropayapp.data.action.LoginResult
import com.rafaelvelazquez.macropayapp.databinding.ActivityLoginBinding
import com.rafaelvelazquez.macropayapp.di.injector
import com.rafaelvelazquez.macropayapp.utils.validEmail
import com.rafaelvelazquez.macropayapp.utils.validatePassWord
import com.rafaelvelazquez.macropayapp.utils.viewModel
import com.rafaelvelazquez.macropayapp.viewmodel.LoginViewModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class LoginActivity : BaseFragmentActivity() {

    private val loginViewModel: LoginViewModel by viewModel {
        injector.loginViewModel
    }

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        bindViewModel()
        configureWidgets()
    }

    private fun configureWidgets() {
        passwordFocusListener()
        emailFocusListener()
        configureLoginButton()
    }

    private fun configureLoginButton() {
        binding.login.setOnClickListener {
            loginViewModel.loginUser(
                user = binding.username.text.toString().toRequestBody(
                    binding.username.text.toString().toMediaTypeOrNull()
                ),
                password = binding.password.text.toString().toRequestBody(
                    binding.password.text.toString().toMediaTypeOrNull()
                )
            )
        }
    }

    private fun bindViewModel() {
        loginViewModel.run {
            getLoginResul().observe(this@LoginActivity, Observer(::handleAccountState))
            getShowProgress().observe(this@LoginActivity, Observer(this@LoginActivity::showLoading))
            getShowError().observe(this@LoginActivity, Observer(this@LoginActivity::showError))
        }
    }

    private fun handleAccountState(loginResult: LoginResult) {
        when(loginResult){
            is LoginResult.Success -> println(loginResult.response)
        }
    }

    private fun passwordFocusListener() {
        binding.password.apply {
            setOnFocusChangeListener { _, focused ->
                if (!focused) {
                    text.validatePassWord()?.let {
                        showError(it)
                    }
                }
            }
        }
    }

    private fun emailFocusListener() {
        binding.username.apply {
            setOnFocusChangeListener { _, focused ->
                if (!focused) {
                    text.validEmail()?.let {
                        showError(it)
                    }
                }
            }
        }
    }

}
