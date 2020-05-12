package com.jp.boilerplate.data.repository

import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.entity.Users
import io.reactivex.Flowable

interface UserRepository {

    fun getUser(forceUpdate: Boolean): Flowable<Users>
}