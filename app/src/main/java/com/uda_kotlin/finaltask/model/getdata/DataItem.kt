package com.uda_kotlin.finaltask.model.getdata

import com.google.gson.annotations.SerializedName

data class DataItem(

    @field:SerializedName("nama")
    val nama: String,

    @field:SerializedName("photo")
    val photo: String,

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("category")
    val category: String
)