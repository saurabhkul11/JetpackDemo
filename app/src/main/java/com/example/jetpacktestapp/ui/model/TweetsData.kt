package com.example.jetpacktestapp.ui.model

import com.google.gson.annotations.SerializedName

data class TweetsData(
    @SerializedName("tweets" ) var tweets : ArrayList<MyTweets> = arrayListOf()
)