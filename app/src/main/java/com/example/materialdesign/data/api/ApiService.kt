package com.example.materialdesign.data.api

import com.example.materialdesign.data.model.public
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("entries")
    fun getPublicList () : Call<public>
}