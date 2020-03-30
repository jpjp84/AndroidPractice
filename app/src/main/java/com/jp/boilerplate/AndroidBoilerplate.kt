package com.jp.boilerplate

import androidx.multidex.MultiDex
import com.jp.boilerplate.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

open class AndroidBoilerplate : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }
}