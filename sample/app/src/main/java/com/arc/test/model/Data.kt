package com.arc.test.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("images")
    val images: List<ImageItem>
)