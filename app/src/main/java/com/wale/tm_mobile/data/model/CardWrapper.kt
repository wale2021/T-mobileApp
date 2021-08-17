package com.wale.tm_mobile.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.wale.tm_mobile.utils.CardType

@JsonClass(generateAdapter = true)
data class CardWrapper(
    @get:Json(name = "card_type") val cardType: CardType,
    val card: Card
)
