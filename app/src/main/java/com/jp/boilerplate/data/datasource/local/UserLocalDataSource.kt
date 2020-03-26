package com.jp.boilerplate.data.datasource.local

import android.content.Context
import android.text.TextUtils
import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.util.SharedPrefUtil
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class UserLocalDataSource constructor(
    private val context: Context
) : UserDataSource {

    override fun getUser(): Flowable<User> {
        return Flowable.defer {
            Flowable.just(SharedPrefUtil.get<User>(context, "user"))
        }
    }

    override fun isCached(): Single<Boolean> {
        return Single.defer {
            Single.just(!TextUtils.isEmpty(SharedPrefUtil.get(context, "user")))
        }
    }

    override fun save(it: User): Completable {
        return Completable.defer {
            SharedPrefUtil.save(context, "user", it)

            Completable.complete()
        }
    }
}