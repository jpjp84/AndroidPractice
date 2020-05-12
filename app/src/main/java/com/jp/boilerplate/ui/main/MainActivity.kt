package com.jp.boilerplate.ui.main

import android.os.Bundle
import com.jp.boilerplate.R
import com.jp.boilerplate.databinding.ActivityMainBinding
import com.jp.boilerplate.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    @Inject
    lateinit var userListAdapter: UserListAdapter

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun getViewLayoutRes() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setAdapter()

        viewModel.updateUser()
    }

    private fun setAdapter() {
        viewBinding.expandableUserList.adapter = userListAdapter
    }
}
