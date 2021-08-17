package com.wale.tm_mobile.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Description(
    val attributes: Attributes,
    val value: String
)