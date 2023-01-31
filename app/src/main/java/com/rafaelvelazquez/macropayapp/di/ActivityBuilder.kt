package com.rafaelvelazquez.macropayapp.di

import com.rafaelvelazquez.macropayapp.view.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}