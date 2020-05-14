package com.jp.boilerplate.ui.home

import android.os.Bundle
import android.view.View
import com.jp.babyfood.ui.base.BaseFragment
import com.jp.boilerplate.R
import com.jp.boilerplate.databinding.FragmentHomeBinding
import com.jp.boilerplate.ui.main.UserListAdapter
import javax.inject.Inject


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    @Inject
    lateinit var userListAdapter: UserListAdapter

    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun getViewLayoutRes(): Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()

        viewModel.updateUser()
    }

    private fun setAdapter() {
        viewBinding.expandableUserList.adapter = userListAdapter
    }
}
