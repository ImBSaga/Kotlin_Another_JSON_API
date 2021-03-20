package com.uda_kotlin.finaltask.model.getdata

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItem(

    @field:SerializedName("nama")
    val nama: String,

    @field:SerializedName("photo")
    val photo: String,

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("category")
    val category: String
) : Parcelable