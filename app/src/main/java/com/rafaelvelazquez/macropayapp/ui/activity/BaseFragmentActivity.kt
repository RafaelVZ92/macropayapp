package com.rafaelvelazquez.macropayapp.ui.activity

import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.rafaelvelazquez.macropayapp.R
import com.rafaelvelazquez.macropayapp.ui.view.LoadingView

open class BaseFragmentActivity: AppCompatActivity() {

    private val loadingView by lazy { LoadingView(this) }

    private fun showProgressDialog(message: String) {
        loadingView.setMessage(message)
        if (loadingView.parent == null) {
            addContentView(
                loadingView,
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
    }

    fun showError(message: String) {
        dismissProgressDialog()
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showLoading(show: Boolean) {
        if (show) showProgressDialog(
            R.string.app_name
        ) else dismissProgressDialog()
    }
    private fun showProgressDialog(@StringRes idMessage: Int) =
        showProgressDialog(getString(idMessage))

    private fun dismissProgressDialog() = loadingView.removeFromParent()
}

fun View.removeFromParent() {
    this.parent?.let {
        (it as ViewGroup).removeView(this)
    }
}