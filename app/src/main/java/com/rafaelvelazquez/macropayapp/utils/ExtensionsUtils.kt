package com.rafaelvelazquez.macropayapp.utils

import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.EditText
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody


fun Editable.validatePassWord(): String? {
    if (this.length < 6) {
        return "Minimum 6 Character Password"
    }
    if (!this.matches(".*[A-Z].*".toRegex())) {
        return "Must Contain 1 Upper-case Character"
    }
    if (!this.matches(".*[a-z].*".toRegex())) {
        return "Must Contain 1 Lower-case Character"
    }
    return null
}

fun Editable.validEmail(): String? {
    if (!Patterns.EMAIL_ADDRESS.matcher(this).matches()) {
        return "Invalid Email Address"
    }
    return null
}

fun Editable?.toRequestBody(): RequestBody {
    return this.toString().toRequestBody(
        this.toString().toMediaTypeOrNull()
    )
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}