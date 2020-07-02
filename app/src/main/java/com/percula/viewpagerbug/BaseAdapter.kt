package com.percula.viewpagerbug

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Originally based on https://medium.com/androiddevelopers/android-data-binding-recyclerview-db7c40d9f0e4
 */
abstract class BaseAdapter<T>: RecyclerView.Adapter<BaseViewHolder<T>>() {

    abstract val items: Collection<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                layoutInflater, viewType, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val obj = getObjForPosition(position)
        holder.bind(obj)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    abstract fun getObjForPosition(position: Int): T

    protected abstract fun getLayoutIdForPosition(position: Int): Int

}