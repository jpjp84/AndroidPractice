package com.jp.boilerplate.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jp.boilerplate.data.entity.Users
import com.jp.boilerplate.ui.main.UserListAdapter

@BindingAdapter("bind_items")
fun bindItems(recyclerView: RecyclerView, users: Users?) {
    (recyclerView.adapter as UserListAdapter?)?.submitList(users)
}