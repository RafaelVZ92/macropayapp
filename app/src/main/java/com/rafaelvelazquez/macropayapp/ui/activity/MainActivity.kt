package com.rafaelvelazquez.macropayapp.ui.activity

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.rafaelvelazquez.macropayapp.R
import com.rafaelvelazquez.macropayapp.databinding.ActivityMainBinding
import com.rafaelvelazquez.macropayapp.launcher.MainActivityArgs
import com.rafaelvelazquez.macropayapp.launcher.MainActivityArgs.Companion.EXTRAS
import java.util.*


class MainActivity : AppCompatActivity() {

    private val extras by lazy {
        intent.extras?.get(EXTRAS) as? MainActivityArgs
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title  = resources.getString(R.string.title_activity_Main)
        configureUserName()
        configureBarCode()
        configureTokenText()
    }

    private fun configureTokenText() {
        binding.materialTextViewToken.text =
            extras?.dashboardData?.token
    }


    @SuppressLint("SetTextI18n")
    private fun configureUserName() {
        binding.materialTextViewUserName.text =
            configureGreeting() +" "+ extras?.dashboardData?.titular
    }

    private fun configureGreeting(): String {
        val c = Calendar.getInstance()

        return when (c[Calendar.HOUR_OF_DAY]) {
            in 0..11 -> {
                resources.getString(R.string.greeting_good_morning)
            }
            in 12..15 -> {
                resources.getString(R.string.greeting_good_afternoon)
            }
            in 16..20 -> {
                resources.getString(R.string.greeting_good_evening)
            }
            in 21..23 -> {
                resources.getString(R.string.greeting_good_night)
            }
            else -> ""
        }

    }

    private fun configureBarCode() {
        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(
            extras?.dashboardData?.token,
            BarcodeFormat.QR_CODE,
            DIMEN,
            DIMEN
        )
        val width = bitMatrix.width
        val height = bitMatrix.height
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (bitMatrix.get(x, y)) Color.BLACK else Color.WHITE)
            }
        }

        binding.imageViewBarCode.setImageBitmap(
            bitmap
        )
    }

    private companion object {
        const val DIMEN = 512
    }

}