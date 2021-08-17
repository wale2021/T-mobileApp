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
        titleView.text = card.card.title?.value
        titleView.textSize = card.card.title?.attributes?.font?.size?.toFloat() ?: 0f
        titleView.setTextColor(Color.parseColor(card.card.title?.attributes?.textColor))

        descriptionView.text = card.card.description?.value
        descriptionView.textSize =
            card.card.description?.attributes?.font?.size?.toFloat() ?: 0f
        descriptionView.setTextColor(Color.parseColor(card.card.description?.attributes?.textColor))
    }

    companion object {
        fun inflate(parent: ViewGroup) = TitleDescriptionViewHolder(
            ItemTitleDescriptionBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

}