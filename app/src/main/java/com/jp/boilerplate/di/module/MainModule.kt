package com.jp.boilerplate.di.module

import androidx.lifecycle.ViewModel
import com.jp.boilerplate.di.ViewModelBuilder
import com.jp.boilerplate.di.ViewModelKey
import com.jp.boilerplate.ui.main.MainActivity
import com.jp.boilerplate.ui.main.MainViewModel
import com.jp.boilerplate.ui.main.UserListAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class,
            UserListModule::class
        ]
    )
    internal abstract fun mainActivity(): MainActivity


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(viewModel: MainViewModel): ViewModel
}

@Module
internal class UserListModule {

    @Provides
    fun provideUserListAdapter(viewModel: MainViewModel, activity: MainActivity): UserListAdapter {
        return UserListAdapter(viewModel, activity)
    }
}
