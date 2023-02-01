package com.rafaelvelazquez.macropayapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafaelvelazquez.macropayapp.databinding.ActivityMainBinding
import com.rafaelvelazquez.macropayapp.di.injector
import com.rafaelvelazquez.macropayapp.launcher.MainActivityArgs
import com.rafaelvelazquez.macropayapp.launcher.MainActivityArgs.Companion.EXTRAS
import com.rafaelvelazquez.macropayapp.utils.viewModel
import com.rafaelvelazquez.macropayapp.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    private val extras by lazy {
        intent.extras?.get(EXTRAS) as? MainActivityArgs
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModel {
        injector.mainViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}