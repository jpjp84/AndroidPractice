package com.jp.boilerplate.data.datasource

import com.jp.boilerplate.data.entity.User
import io.reactivex.rxjava3.core.Flowable

interface UserDataSource {

    fun getUser(): Flowable<User>
}