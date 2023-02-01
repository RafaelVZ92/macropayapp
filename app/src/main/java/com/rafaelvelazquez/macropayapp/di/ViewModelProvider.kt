package com.rafaelvelazquez.macropayapp.di

import com.rafaelvelazquez.macropayapp.viewmodel.LoginViewModel
import com.rafaelvelazquez.macropayapp.viewmodel.MainViewModel

interface ViewModelProvider: MainViewModels

interface MainViewModels {
    val mainViewModel: MainViewModel
    val loginViewModel: LoginViewModel
}