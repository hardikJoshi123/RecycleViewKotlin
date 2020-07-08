package com.arc.test.model

import com.google.gson.annotations.SerializedName

data class ImageItem(
    @SerializedName("id")
    val imageId: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("large_url")
    val large_url: String

)