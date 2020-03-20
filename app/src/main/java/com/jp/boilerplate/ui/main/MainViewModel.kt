package com.jp.boilerplate.ui.main

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {
    val title = "View Model Test"

    val description = "View Model description"
}