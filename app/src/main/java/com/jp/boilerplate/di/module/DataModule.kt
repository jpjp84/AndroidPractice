package com.jp.boilerplate.di.module

import com.jp.boilerplate.data.UserRepositoryImpl
import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.datasource.local.UserLocalDataSource
import com.jp.boilerplate.data.datasource.remote.UserRemoteDataSource
import com.jp.boilerplate.data.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RepositoryBindModule::class])
object DataModule {

    @JvmStatic
    @Singleton
    @Provides
    @AppModule.LocalDataSource
    fun bindLocalUserDataSource(): UserDataSource {
        return UserLocalDataSource()
    }

    @JvmStatic
    @Singleton
    @Provides
    @AppModule.RemoteDataSource
    fun bindRemoteUserDataSource(): UserDataSource {
        return UserRemoteDataSource()
    }
}

@Module
abstract class RepositoryBindModule {

    @Singleton
    @Binds
    abstract fun bindRepository(userRepository: UserRepositoryImpl): UserRepository
}