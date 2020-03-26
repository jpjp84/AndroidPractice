package com.jp.boilerplate.data.datasource.local

import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.entity.User
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class UserLocalDataSource : UserDataSource {

    override fun getUser(): Flowable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCached(): Single<Boolean> {
        //TODO always false
        return Single.defer { Single.just(false) }
    }

    override fun save(it: User): Completable {
        return Completable.defer {
            //TODO Save Shared Pref. or DB
            Completable.complete()
        }
    }
}