package com.rafaelvelazquez.macropayapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class AppBaseViewModel : ViewModel() {
    protected val disposable = CompositeDisposable()

    protected val showProgress = MutableLiveData<Boolean>()
    protected val showError = MutableLiveData<Throwable>()

    fun getShowProgress(): LiveData<Boolean> = showProgress
    fun getShowError(): LiveData<Throwable> = showError

    override fun onCleared() {
        disposable.clear()
    }
}
