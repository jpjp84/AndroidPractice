package com.jp.boilerplate.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.entity.Users
import com.jp.boilerplate.data.repository.UserRepository
import com.jp.boilerplate.ui.base.BaseViewModel
import com.jp.boilerplate.util.Event
import com.orhanobut.logger.Logger
import javax.inject.Inject


class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    private val _users = MutableLiveData<Users>()
    val users: LiveData<Users> = _users

    private val _openUserDetailEvent = MutableLiveData<Event<User>>()
    val openUserDetailEvent: LiveData<Event<User>> = _openUserDetailEvent

    fun updateUser() {
        addDisposable(
            userRepository.getUser(true).subscribe(
                {
                    _users.value = it
                },
                { Logger.e("Update User Exception", it) }
            )
        )
    }

    fun openUserDetail(user: User) {
        _openUserDetailEvent.value = Event(user)
    }
}