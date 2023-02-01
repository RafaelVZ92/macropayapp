package com.rafaelvelazquez.macropayapp.ui.activity

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
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
        configureUserName()
        configureBarCode()
    }

    private fun configureUserName() {
        binding.materialTextViewUserName.text =
            "Good morning: "+extras?.dashboardData?.titular
    }

    private fun configureBarCode() {
        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(
            extras?.dashboardData?.solicitud,
            BarcodeFormat.QR_CODE,
            512,
            512)
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


}