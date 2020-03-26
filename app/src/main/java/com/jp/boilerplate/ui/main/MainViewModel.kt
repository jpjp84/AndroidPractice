package com.jp.boilerplate.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jp.boilerplate.data.repository.UserRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    val title = "View Model Test"

    val description = "View Model description"

    fun printUser() {
        userRepository.getUser().subscribe({
            Log.i("TAG", it.name)
        }, {
            Log.e("TAG", "Throwable : ", it)
        })
    }
}