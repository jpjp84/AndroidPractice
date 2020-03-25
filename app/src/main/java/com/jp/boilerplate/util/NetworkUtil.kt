package com.jp.boilerplate.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkUtil {
    fun <T> getAPI(apiInterface: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://android-boilerplate-925b1.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        
        return retrofit.create(apiInterface)
    }
}