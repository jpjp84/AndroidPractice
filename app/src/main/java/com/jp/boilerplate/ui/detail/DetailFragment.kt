package com.jp.boilerplate.ui.detail

import android.os.Bundle
import android.view.View
import com.jp.babyfood.ui.base.BaseFragment
import com.jp.boilerplate.R
import com.jp.boilerplate.databinding.FragmentHomeBinding
import com.jp.boilerplate.ui.main.UserListAdapter
import javax.inject.Inject


class DetailFragment : BaseFragment<DetailViewModel, FragmentHomeBinding>() {

    override fun getViewModelClass(): Class<DetailViewModel> = DetailViewModel::class.java

    override fun getViewLayoutRes(): Int = R.layout.fragment_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.updateUser()
    }
}
