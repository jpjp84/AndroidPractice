package com.jp.boilerplate.di.module

import androidx.lifecycle.ViewModel
import com.jp.boilerplate.di.ViewModelBuilder
import com.jp.boilerplate.di.ViewModelKey
import com.jp.boilerplate.ui.home.HomeFragment
import com.jp.boilerplate.ui.home.HomeViewModel
import com.jp.boilerplate.ui.main.UserListAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HomeModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class,
            UserListModule::class
        ]
    )
    internal abstract fun homeFragment(): HomeFragment


    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindViewModel(viewModel: HomeViewModel): ViewModel
}

@Module
internal class UserListModule {

    @Provides
    fun provideUserListAdapter(viewModel: HomeViewModel, fragment: HomeFragment): UserListAdapter {
        return UserListAdapter(viewModel, fragment)
    }
}
