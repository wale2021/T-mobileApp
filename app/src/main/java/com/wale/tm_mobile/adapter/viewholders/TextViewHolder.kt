package com.wale.tm_mobile.adapter.viewholders

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wale.tm_mobile.data.model.CardWrapper
import com.wale.tm_mobile.databinding.ItemTextBinding

class TextViewHolder(private val binding: ItemTextBinding) : BaseViewHolder(binding) {

    override fun loadData(card: CardWrapper) = with(binding.textTv) {
        text = card.card.value
        textSize = card.card.attributes?.font?.size?.toFloat() ?: 0f
        setTextColor(Color.parseColor(card.card.attributes?.textColor))
    }

    companion object {
        fun inflate(parent: ViewGroup) = TextViewHolder(
            ItemTextBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}