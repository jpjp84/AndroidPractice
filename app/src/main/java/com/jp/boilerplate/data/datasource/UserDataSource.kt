package com.jp.boilerplate.data.datasource

import com.jp.boilerplate.data.entity.Users
import io.reactivex.Flowable

interface UserDataSource : BaseDataSource<Users> {

    fun getUsers(): Flowable<Users>
}