package com.wale.tm_mobile.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Title(
    val attributes: Attributes,
    val value: String
)