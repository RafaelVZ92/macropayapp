package com.rafaelvelazquez.macropayapp

import android.app.Application
import com.rafaelvelazquez.macropayapp.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MacroPayApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .androidInjector()
            .apply { inject(this@MacroPayApp) }
    }

    override fun androidInjector() = androidInjector
}