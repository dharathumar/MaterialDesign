package com.example.materialdesign.data.model

import com.google.gson.annotations.SerializedName

data class Entry( val API: String,
    val Auth: String,
    val Category: String,
    val Cors: String,
    val Description: String,
    val HTTPS: Boolean,
    val Link: String)

/* {
    @SerializedName("API")
    var API = ""

    @SerializedName("Auth")
    var Auth = ""

    @SerializedName("Category")
    var Category = ""

    @SerializedName("Cors")
    var Cors = ""

    @SerializedName("Description")
    var Description = ""

    @SerializedName("HTTPS")
    var HTTPS = ""

    @SerializedName("Link")
    var Link = ""
}*/