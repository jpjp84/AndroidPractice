package com.jp.boilerplate.data.entity

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.jp.boilerplate.BR
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User constructor(val name: String, var age: Int) : BaseObservable(), Parcelable {

    @IgnoredOnParcel
    var expand: Boolean = false
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.expand)
        }
}

typealias Users = List<User>