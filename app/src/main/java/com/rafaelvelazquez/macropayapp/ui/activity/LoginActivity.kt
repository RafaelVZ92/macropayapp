package com.rafaelvelazquez.macropayapp.ui.activity

import androidx.lifecycle.Observer
import android.os.Bundle
import com.rafaelvelazquez.macropayapp.R
import com.rafaelvelazquez.macropayapp.data.action.LoginResult
import com.rafaelvelazquez.macropayapp.databinding.ActivityLoginBinding
import com.rafaelvelazquez.macropayapp.di.injector
import com.rafaelvelazquez.macropayapp.launcher.MainActivityArgs
import com.rafaelvelazquez.macropayapp.utils.*
import com.rafaelvelazquez.macropayapp.viewmodel.LoginViewModel

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
        title = resources.getString(R.string.title_activity_login)
        configureWidgets()
    }

    private fun configureWidgets() {
        passwordFocusListener()
        emailFocusListener()
        configureLoginButton()
        enableButton()
    }

    private fun enableButton() {
        binding.apply {
            login.isEnabled = !textInputEditTextUser?.text.isNullOrBlank() &&
                    !textInputEditTextPassword?.text.isNullOrBlank()
        }
    }

    private fun configureLoginButton() {
        binding.apply {
            login.apply {
                setOnClickListener {
                    loginViewModel.loginUser(
                        user = binding.textInputEditTextUser?.text.toRequestBody(),
                        password = binding.textInputEditTextPassword?.text.toRequestBody()
                    )
                }
            }
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
        when (loginResult) {
            is LoginResult.Success -> startActivity(
                MainActivityArgs(
                    loginResult.domainModel
                ).intent(this)
            )
        }
    }


    private fun emailFocusListener() {
        binding.textInputEditTextUser?.apply {
            setOnFocusChangeListener { _, focused ->
                if (!focused) {
                    text?.validEmail()?.let {
                        binding.textInputLayoutUser?.error = it
                    }
                }
            }
        }
    }

    private fun passwordFocusListener() {
        binding.textInputEditTextPassword?.apply {
            setOnFocusChangeListener { _, focused ->
                if (!focused) {
                    text?.validatePassWord()?.let {
                        binding.textInputLayoutPassword?.error = it
                    }
                }
            }
            afterTextChanged {
                enableButton()
            }
        }
    }

}
