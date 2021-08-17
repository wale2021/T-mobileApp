package com.wale.tm_mobile.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Card(
    val value: String = "",
    val attributes: Attributes?,
    val image: Image?,
    val description: Description?,
    val title: Title?
)
