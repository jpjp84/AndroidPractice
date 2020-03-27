package com.jp.boilerplate.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.data.repository.UserRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun updateUser() {
        disposables.add(
            userRepository.getUser(true).subscribe(
                { _user.value = it },
                { Log.e("AB_TAG", "Throwable : ", it) }
            )
        )
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}