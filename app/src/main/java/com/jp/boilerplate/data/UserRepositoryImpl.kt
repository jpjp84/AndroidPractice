package com.jp.boilerplate.data

import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.entity.Users
import com.jp.boilerplate.data.repository.UserRepository
import com.jp.boilerplate.di.module.AppModule
import io.reactivex.Flowable
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    @AppModule.LocalDataSource private val userLocalDataSource: UserDataSource,
    @AppModule.RemoteDataSource private val userRemoteDataSource: UserDataSource
) : UserRepository {

    private var user: Users? = null

    override fun getUser(forceUpdate: Boolean): Flowable<Users> {
        return userLocalDataSource.isCached()
            .flatMapPublisher {
                if (forceUpdate || !it) {
                    userRemoteDataSource.getUsers()
                } else {
                    userLocalDataSource.getUsers()
                }
            }
            .flatMap {
                user = it
                userLocalDataSource.save(it).toSingle { it }.toFlowable()
            }
    }
}