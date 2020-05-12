package com.jp.boilerplate.data.datasource.api

import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.entity.Users
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Headers

interface UserAPI {

    @Headers(
        "accept: application/json",
        "content-type: application/json"
    )
    @GET("user.json")
    fun getUser(): Flowable<Users>
}