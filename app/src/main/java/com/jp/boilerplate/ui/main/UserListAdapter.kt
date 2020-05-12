package com.jp.boilerplate.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jp.boilerplate.data.entity.User
import com.jp.boilerplate.databinding.RowUserBinding

class UserListAdapter(val viewModel: MainViewModel) :
    ListAdapter<User, RecyclerView.ViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserViewHolder).bind(viewModel, getItem(position))
    }

    class UserViewHolder(private val binding: RowUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: MainViewModel, item: User) {
            binding.viewModel = viewModel
            binding.user = item
        }

        companion object {
            fun from(parent: ViewGroup): UserViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                return UserViewHolder(
                    RowUserBinding.inflate(
                        layoutInflater,
                        parent,
                        false
                    )
                )
            }
        }
    }
}

class UserDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.name == newItem.name && oldItem.age == newItem.age
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}
