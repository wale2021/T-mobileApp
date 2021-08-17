package com.wale.tm_mobile.adapter.viewholders

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.wale.tm_mobile.data.model.CardWrapper

abstract class BaseViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    abstract fun loadData(card: CardWrapper)
}