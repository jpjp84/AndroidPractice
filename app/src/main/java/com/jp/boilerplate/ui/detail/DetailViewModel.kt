package com.jp.boilerplate.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.entity.Users
import com.jp.boilerplate.data.repository.UserRepository
import com.jp.boilerplate.ui.base.BaseViewModel
import com.orhanobut.logger.Logger
import javax.inject.Inject


class DetailViewModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun updateUser(userArg: User) {
        _user.value = userArg
    }
}