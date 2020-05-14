package com.jp.boilerplate.di.module

import androidx.lifecycle.ViewModel
import com.jp.boilerplate.di.ViewModelBuilder
import com.jp.boilerplate.di.ViewModelKey
import com.jp.boilerplate.ui.detail.DetailFragment
import com.jp.boilerplate.ui.detail.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class DetailModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun homeFragment(): DetailFragment


    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindViewModel(viewModel: DetailViewModel): ViewModel
}