package com.jp.boilerplate.di.module

import androidx.lifecycle.ViewModel
import com.jp.boilerplate.di.ViewModelKey
import com.jp.boilerplate.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(viewModel: MainViewModel): ViewModel
}