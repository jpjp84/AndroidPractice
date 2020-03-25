package com.jp.boilerplate.data.datasource.local

import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.entity.User
import io.reactivex.rxjava3.core.Flowable

class UserLocalDataSource : UserDataSource {

    override fun getUser(): Flowable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}