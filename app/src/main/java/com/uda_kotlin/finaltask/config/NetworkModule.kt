package com.uda_kotlin.finaltask.config

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkModule {

    fun getRetrofit(): Retrofit {

        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder().baseUrl("http://10.0.2.2/database_kotlin/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    //added after Api Service
    fun service() : ApiService = getRetrofit().create(ApiService::class.java)
}