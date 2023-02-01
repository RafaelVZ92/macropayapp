package com.rafaelvelazquez.macropayapp.di

import android.app.Application
import androidx.fragment.app.FragmentActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppMainModule::class,
        ActivityBuilder::class,
        ApiServiceModule::class,
        MapperModule::class
    ]
)
interface AppComponent :
    ViewModelProvider {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }

    fun androidInjector(): DispatchingAndroidInjector<Any>
}

val FragmentActivity.injector
    get() = DaggerAppComponent
        .builder()
        .application(application)
        .build()

