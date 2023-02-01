package com.rafaelvelazquez.macropayapp.utils

import android.text.Editable
import android.util.Patterns


fun Editable.validatePassWord(): String? {
    if (this.length < 8) {
        return "Minimum 8 Character Password"
    }
    if (!this.matches(".*[A-Z].*".toRegex())) {
        return "Must Contain 1 Upper-case Character"
    }
    if (!this.matches(".*[a-z].*".toRegex())) {
        return "Must Contain 1 Lower-case Character"
    }
    if (!this.matches(".*[@#\$%^&+=].*".toRegex())) {
        return "Must Contain 1 Special Character (@#\$%^&+=)"
    }
    return null
}

fun Editable.validEmail(): String? {
    if (!Patterns.EMAIL_ADDRESS.matcher(this).matches()) {
        return "Invalid Email Address"
    }
    return null
}

//fun <T> Single<T>.applySchedulers(): Single<T> {
//    return subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//}