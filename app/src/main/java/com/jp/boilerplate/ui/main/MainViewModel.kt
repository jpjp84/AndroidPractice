package com.jp.boilerplate.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jp.boilerplate.data.entity.Users
import com.jp.boilerplate.data.repository.UserRepository
import com.jp.boilerplate.ui.base.BaseViewModel
import com.orhanobut.logger.Logger
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    private val _users = MutableLiveData<Users>()
    val users: LiveData<Users> = _users

    fun updateUser() {
        addDisposable(
            userRepository.getUser(true).subscribe(
                {
                    Logger.i("$it")
                    _users.value = it
                },
                { Log.e("AB_TAG", "Throwable : ", it) }
            )
        )
    }
}