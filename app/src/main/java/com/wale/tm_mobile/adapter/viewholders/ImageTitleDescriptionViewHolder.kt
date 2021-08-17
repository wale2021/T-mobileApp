package com.wale.tm_mobile.adapter.viewholders

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wale.tm_mobile.data.model.CardWrapper
import com.wale.tm_mobile.databinding.ItemImageTitleDescriptionBinding
import com.wale.tm_mobile.utils.loadImage

class ImageTitleDescriptionViewHolder(private val binding: ItemImageTitleDescriptionBinding) :
    BaseViewHolder(binding) {

    override fun loadData(card: CardWrapper) = with(binding) {
        imageTitleTv.text = card.card.title?.value
        imageTitleTv.textSize = card.card.title?.attributes?.font?.size?.toFloat() ?: 0f
        imageTitleTv.setTextColor(Color.parseColor(card.card.title?.attributes?.textColor))
        imageDescriptionTv.text = card.card.description?.value
        imageDescriptionTv.textSize = card.card.description?.attributes?.font?.size?.toFloat() ?: 0F
        imageDescriptionTv.setTextColor(Color.parseColor(card.card.description?.attributes?.textColor))

        cardImageIv.layoutParams.height = card.card.image?.size?.height ?: 0
        cardImageIv.layoutParams.width = card.card.image?.size?.width ?: 0
        cardImageIv.requestLayout()
        cardImageIv.loadImage(card.card.image?.url ?: "")
    }

    companion object {
        fun inflate(parent: ViewGroup) = ImageTitleDescriptionViewHolder(
            ItemImageTitleDescriptionBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}