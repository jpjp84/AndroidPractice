package com.jp.boilerplate.di.component

import android.content.Context
import com.jp.boilerplate.AndroidBoilerplate
import com.jp.boilerplate.di.module.AppModule
import com.jp.boilerplate.di.module.DataModule
import com.jp.boilerplate.di.module.HomeModule
import com.jp.boilerplate.di.module.MainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        DataModule::class,
        MainModule::class,
        HomeModule::class
    ]
)
interface AppComponent : AndroidInjector<AndroidBoilerplate> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

}