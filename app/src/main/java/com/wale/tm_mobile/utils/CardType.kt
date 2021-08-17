package com.wale.tm_mobile.utils

import com.squareup.moshi.Json

enum class CardType(val type: String) {
    @Json(name = "text")
    TEXT("text"),

    @Json(name = "title_description")
    TITLE_DESCRIPTION("title_description"),

    @Json(name = "image_title_description")
    IMAGE_TITLE_DESCRIPTION("image_title_description")
}