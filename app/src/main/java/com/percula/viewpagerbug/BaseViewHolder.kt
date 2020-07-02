package com.percula.viewpagerbug

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Originally based on https://medium.com/androiddevelopers/android-data-binding-recyclerview-db7c40d9f0e4
 */
open class BaseViewHolder<T>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(obj: T) {
        binding.setVariable(BR.obj, obj)
        binding.executePendingBindings()
    }

}