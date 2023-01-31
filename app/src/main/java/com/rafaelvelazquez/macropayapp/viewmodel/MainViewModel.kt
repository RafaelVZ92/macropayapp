package com.rafaelvelazquez.macropayapp.viewmodel

import androidx.lifecycle.ViewModel
import com.rafaelvelazquez.macropayapp.repository.AppRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    fun printThing(){

    }
}