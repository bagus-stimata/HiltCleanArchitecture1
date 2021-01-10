package com.example.hiltcleanarchitecture1.presentation.ui.contributor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.hiltcleanarchitecture1.R
import com.example.hiltcleanarchitecture1.presentation.base.BaseRecyclerAdapter
import com.example.hiltcleanarchitecture1.databinding.CustomContributeItemBinding
import com.example.hiltcleanarchitecture1.presentation.extension.circleUrl
import com.example.hiltcleanarchitecture1.presentation.model.ContributorItem

class ContributorAdapter(
    private val dataBindingComponent: DataBindingComponent,
    private val callback: ((ContributorItem) -> Unit)?
) : BaseRecyclerAdapter<ContributorItem>(

    callBack = object : DiffUtil.ItemCallback<ContributorItem>() {
        override fun areItemsTheSame(oldItem: ContributorItem, newItem: ContributorItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ContributorItem, newItem: ContributorItem): Boolean {
            return oldItem.login == newItem.login && oldItem.avatarUrl == newItem.avatarUrl
        }
    }) {

    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding =
        DataBindingUtil.inflate<CustomContributeItemBinding>(
            LayoutInflater.from(parent.context), R.layout.custom_contribute_item,
            parent, false, dataBindingComponent
        ).apply {
            root.setOnClickListener {
                this.contributor?.let { item ->
                    callback?.invoke(item)
                }
            }
        }

    override fun bind(binding: ViewDataBinding, item: ContributorItem) {
        if (binding is CustomContributeItemBinding) {
            binding.contributor = item
            binding.avatar.circleUrl(item.avatarUrl)
        }
    }
}
