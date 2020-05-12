package com.jp.boilerplate.data.datasource

import io.reactivex.Completable
import io.reactivex.Single

interface BaseDataSource<T> {

    fun isCached(): Single<Boolean>

    fun save(it: T): Completable
}