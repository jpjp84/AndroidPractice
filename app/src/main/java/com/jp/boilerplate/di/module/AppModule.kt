package com.jp.boilerplate.di.module

import android.app.Application
import com.jp.boilerplate.AndroidBoilerplate
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideApplication(context: AndroidBoilerplate): Application = context
}