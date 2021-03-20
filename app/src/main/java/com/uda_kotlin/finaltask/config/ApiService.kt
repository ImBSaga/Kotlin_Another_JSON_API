package com.uda_kotlin.finaltask.config

import com.uda_kotlin.finaltask.model.action.ResponseAction
import com.uda_kotlin.finaltask.model.getdata.Response
import com.uda_kotlin.finaltask.model.getdata.ResponseGetData
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    //getData
    @GET("getData.php")
    fun getData(): Call<Response>

    //getDataById
    @GET("getData.php")
    fun getDataById(@Query("id") id: String): Call<Response>

    //insert
    @FormUrlEncoded
    @POST("insert.php")
    fun insertData(
        @Field("nama") nama: String,
        @Field("category") category: String,
        @Field("photo") photo: String
    ): Call<ResponseAction>

    //update
    @FormUrlEncoded
    @POST("update.php")
    fun updateData(
        @Field("id") id: String,
        @Field("nama") nama: String,
        @Field("category") category: String,
        @Field("photo") photo: String
    ): Call<ResponseAction>

    //delete
    @FormUrlEncoded
    @POST("delete.php")
    fun deleteData(@Field("id") id: String): Call<ResponseAction>

}