package com.example.jetpacktestapp.ui.model

import com.google.gson.annotations.SerializedName

data class MyTweets(

    @SerializedName("category" ) var category : String? = null,
    @SerializedName("text"     ) var text     : String? = null
)