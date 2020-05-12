package com.jp.boilerplate.data.datasource.remote

import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.entity.Users
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserRemoteDataSource : UserDataSource {

    override fun getUsers(): Flowable<Users> {
        return Flowable.defer { Flowable.just(mockingUsers()) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun mockingUsers(): Users {
        return mutableListOf(User("jp", 30), User("jh", 20), User("ar", 10))
    }

    override fun isCached(): Single<Boolean> {
        throw UnsupportedOperationException()
    }

    override fun save(it: Users): Completable {
        throw UnsupportedOperationException()
    }
}