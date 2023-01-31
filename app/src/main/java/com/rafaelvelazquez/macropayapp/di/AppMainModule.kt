package com.rafaelvelazquez.macropayapp.di

import android.app.Application
import android.content.Context
import com.rafaelvelazquez.macropayapp.MacroPayApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppMainModule {

    @Provides
    @Singleton
    fun providesContext(context: MacroPayApp): Context = context.applicationContext

    @Provides
    @Singleton
    fun providesApplication(application: MacroPayApp): Application = application
}
