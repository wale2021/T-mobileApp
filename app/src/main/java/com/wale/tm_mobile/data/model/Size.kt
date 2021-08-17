package com.wale.tm_mobile.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Size(
    val height: Int,
    val width: Int
)