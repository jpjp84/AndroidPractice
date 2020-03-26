package com.jp.boilerplate.data.repository

import com.jp.boilerplate.data.entity.User
import io.reactivex.Flowable

interface UserRepository {

    fun getName(): Flowable<User>

    fun getAge(): Int

    fun isAdult(): Boolean
}