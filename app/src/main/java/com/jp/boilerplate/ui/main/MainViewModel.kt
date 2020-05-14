package com.jp.boilerplate.ui.main

import com.jp.boilerplate.data.repository.UserRepository
import com.jp.boilerplate.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel()