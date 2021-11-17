package com.example.materialdesign.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val URL ="https://api.publicapis.org/"

    //retrofit builder
    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

   // private val retrofit = builder.build()
    val service = builder.create(ApiService::class.java)
    val requestCall =service.getPublicList()




}