package com.jp.boilerplate.data.entity

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.jp.boilerplate.BR

data class User constructor(val name: String, var age: Int) : BaseObservable() {

    var expand: Boolean = false
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.expand)
        }
}

typealias Users = List<User>