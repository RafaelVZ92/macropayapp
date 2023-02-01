package com.rafaelvelazquez.macropayapp.di

import com.rafaelvelazquez.macropayapp.viewmodel.LoginViewModel

interface ViewModelProvider: MainViewModels

interface MainViewModels {
    val loginViewModel: LoginViewModel
}