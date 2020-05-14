package com.jp.boilerplate.ui.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.jp.babyfood.ui.base.BaseFragment
import com.jp.boilerplate.R
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.databinding.FragmentHomeBinding
import com.jp.boilerplate.ui.main.UserListAdapter
import com.jp.boilerplate.util.EventObserver
import javax.inject.Inject


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    @Inject
    lateinit var userListAdapter: UserListAdapter

    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun getViewLayoutRes(): Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObservers()
        setAdapter()

        viewModel.updateUser()
    }

    private fun setObservers() {
        viewModel.openUserDetailEvent.observe(viewLifecycleOwner, EventObserver {
            openUserDetail(it)
        })
    }

    private fun openUserDetail(user: User) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
        findNavController().navigate(action)
    }

    private fun setAdapter() {
        viewBinding.expandableUserList.adapter = userListAdapter
    }
}
