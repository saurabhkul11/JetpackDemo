package com.example.jetpacktestapp.ui.api

import com.example.jetpacktestapp.ui.model.MyTweets
import com.example.jetpacktestapp.ui.model.QuoteData
import com.example.jetpacktestapp.ui.model.Tweet
import com.example.jetpacktestapp.ui.model.TweetsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {

    @GET("v3/b/656eaf620574da7622d05ed9")
    suspend fun getQuotes():Response<QuoteData>

    @GET("v3/b/6576dc88dc7465401881aded?meta=false")
    suspend fun getTweets(@Header("X-Json-Path")category: String):Response<List<MyTweets>>

    @GET("v3/b/6576dc88dc7465401881aded?meta=false")
    @Headers("X-Json-Path:tweets..category")
    suspend fun getCategory():Response<List<String>>



}