package com.wale.tm_mobile.adapter.viewholders

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wale.tm_mobile.data.model.CardWrapper
import com.wale.tm_mobile.databinding.ItemTitleDescriptionBinding

class TitleDescriptionViewHolder(
    private val binding: ItemTitleDescriptionBinding
) : BaseViewHolder(binding) {
    override fun loadData(card: CardWrapper) = with(binding) {
        titleTv.text = card.card.title?.value
        titleTv.textSize = card.card.title?.attributes?.font?.size?.toFloat() ?: 0f
        titleTv.setTextColor(Color.parseColor(card.card.title?.attributes?.textColor))

        descriptionTv.text = card.card.description?.value
        descriptionTv.textSize =
            card.card.description?.attributes?.font?.size?.toFloat() ?: 0f
        descriptionTv.setTextColor(Color.parseColor(card.card.description?.attributes?.textColor))
    }

    companion object {
        fun inflate(parent: ViewGroup) = TitleDescriptionViewHolder(
            ItemTitleDescriptionBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

}