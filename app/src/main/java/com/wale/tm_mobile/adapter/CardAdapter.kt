package com.wale.tm_mobile.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wale.tm_mobile.adapter.viewholders.BaseViewHolder
import com.wale.tm_mobile.adapter.viewholders.ImageTitleDescriptionViewHolder
import com.wale.tm_mobile.adapter.viewholders.TextViewHolder
import com.wale.tm_mobile.adapter.viewholders.TitleDescriptionViewHolder
import com.wale.tm_mobile.data.model.CardWrapper
import com.wale.tm_mobile.utils.CardType


class CardAdapter(
    private val cardList: List<CardWrapper>
) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        CardType.TITLE_DESCRIPTION.ordinal -> TitleDescriptionViewHolder.inflate(parent)
        CardType.IMAGE_TITLE_DESCRIPTION.ordinal -> ImageTitleDescriptionViewHolder.inflate(parent)
        else -> TextViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.loadData(cardList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (cardList[position].cardType) {
            CardType.TEXT -> CardType.TEXT.ordinal
            CardType.TITLE_DESCRIPTION -> CardType.TITLE_DESCRIPTION.ordinal
            CardType.IMAGE_TITLE_DESCRIPTION -> CardType.IMAGE_TITLE_DESCRIPTION.ordinal
        }
    }

    override fun getItemCount(): Int = cardList.size

}