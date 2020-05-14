package com.jp.boilerplate.ui.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.jp.boilerplate.ui.base.BaseFragment
import com.jp.boilerplate.R
import com.jp.boilerplate.databinding.FragmentHomeBinding


class DetailFragment : BaseFragment<DetailViewModel, FragmentHomeBinding>() {

    private val args: DetailFragmentArgs by navArgs()

    override fun getViewModelClass(): Class<DetailViewModel> = DetailViewModel::class.java

    override fun getViewLayoutRes(): Int = R.layout.fragment_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.updateUser(args.user)
    }
}
