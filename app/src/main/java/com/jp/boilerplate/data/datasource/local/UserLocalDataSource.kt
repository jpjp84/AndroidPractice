package com.jp.boilerplate.data.datasource.local

import android.content.Context
import android.text.TextUtils
import com.jp.boilerplate.data.datasource.UserDataSource
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.entity.Users
import com.jp.boilerplate.util.SharedPrefUtil
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class UserLocalDataSource constructor(
    private val context: Context
) : UserDataSource {

    override fun getUsers(): Flowable<Users> {
        return Flowable.defer {
            Flowable.just(SharedPrefUtil.get<Users>(context, "users"))
        }
    }

    override fun isCached(): Single<Boolean> {
        return Single.defer {
            Single.just(!TextUtils.isEmpty(SharedPrefUtil.get(context, "users")))
        }
    }

    override fun save(it: Users): Completable {
        return Completable.defer {
            SharedPrefUtil.save(context, "users", it)

            Completable.complete()
        }
    }
}