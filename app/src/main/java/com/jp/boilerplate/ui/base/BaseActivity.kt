package com.jp.boilerplate.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jp.boilerplate.BR
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<VM : ViewModel, VB : ViewDataBinding> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract fun getViewModelClass(): Class<VM>

    protected val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(getViewModelClass())
    }

    @LayoutRes
    abstract fun getViewLayoutRes(): Int

    private val viewBinding by lazy {
        DataBindingUtil.setContentView<VB>(this, getViewLayoutRes())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.apply {
            this.setVariable(BR.viewModel, viewModel)
            viewBinding.lifecycleOwner = this@BaseActivity
            this.executePendingBindings()
        }
    }
}