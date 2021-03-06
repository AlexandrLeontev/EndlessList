package com.example.endlesslists.domain.models

import com.google.gson.annotations.SerializedName

data class Data(
    val kind: String,
    @SerializedName("data")
    val data: InsideData
)
