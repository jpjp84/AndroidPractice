package com.jp.boilerplate.data.datasource

import com.jp.boilerplate.data.entity.User
import io.reactivex.Flowable

interface UserDataSource : BaseDataSource {

    fun getUser(): Flowable<User>
}