package com.jp.boilerplate.data

import android.util.Log
import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.repository.UserRepository
import com.jp.boilerplate.di.module.AppModule
import io.reactivex.Flowable
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    @AppModule.LocalDataSource private val userLocalDataSource: UserDataSource,
    @AppModule.RemoteDataSource private val userRemoteDataSource: UserDataSource
) : UserRepository {

    private var user: User? = null

    override fun getUser(forceUpdate: Boolean): Flowable<User> {
        return userLocalDataSource.isCached()
            .flatMapPublisher {
                Log.i("AB_${this.javaClass.simpleName}", "it : $it")
                if (forceUpdate || !it) {
                    userRemoteDataSource.getUser()
                } else {
                    userLocalDataSource.getUser()
                }
            }
            .flatMap {
                user = it
                userLocalDataSource.save(it).toSingle { it }.toFlowable()
            }
    }

    override fun isAdult(): Boolean {
        return user?.age!! > 19
    }
}