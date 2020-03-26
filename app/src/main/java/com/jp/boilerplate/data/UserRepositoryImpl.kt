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

    override fun getUser(): Flowable<User> {
        return userLocalDataSource.isCached()
            .flatMapPublisher {
                Log.i("AB_${this.javaClass.simpleName}", "it : $it")
                if (it) {
                    userLocalDataSource.getUser()
                } else {
                    userRemoteDataSource.getUser()
                }
            }
            .flatMap {
                userLocalDataSource.save(it).toSingle { it }.toFlowable()
            }
    }

    override fun getAge(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isAdult(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}