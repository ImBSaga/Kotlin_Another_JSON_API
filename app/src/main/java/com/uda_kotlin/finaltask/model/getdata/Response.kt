package com.uda_kotlin.finaltask.model.getdata

import com.google.gson.annotations.SerializedName

data class Response(

    @field:SerializedName("data")
    val data: List<DataItem>,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("isSuccess")
    val isSuccess: Boolean
)