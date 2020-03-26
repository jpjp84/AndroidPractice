package com.jp.boilerplate.di.module

import android.app.Application
import com.jp.boilerplate.AndroidBoilerplate
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteDataSource

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalDataSource

    @JvmStatic
    @Singleton
    @Provides
    fun provideApplication(context: AndroidBoilerplate): Application = context
}