package com.jp.boilerplate.data.datasource.remote

import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.datasource.api.UserAPI
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.util.NetworkUtil
import io.reactivex.rxjava3.core.Flowable

class UserRemoteDataSource : UserDataSource {

    override fun getUser(): Flowable<User> {
        return NetworkUtil.getAPI(UserAPI::class.java).getUser()
    }

}