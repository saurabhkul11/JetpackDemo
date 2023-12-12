package com.example.jetpacktestapp.ui.repo

import com.example.jetpacktestapp.ui.api.ApiService
import com.example.jetpacktestapp.ui.model.MyTweets
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(var apiService: ApiService) {

    private var _tweetData = MutableStateFlow<List<MyTweets>>(emptyList())
    val _statetweetData: StateFlow<List<MyTweets>>
        get() = _tweetData

    suspend fun getTweetData(category:String){
        val response=apiService.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body()!=null){
            _tweetData.emit(response.body()!!)
        }
    }

    var _categoryData = MutableStateFlow<List<String>>(emptyList())
    val _statecategoryData: StateFlow<List<String>>
        get() = _categoryData

    suspend fun getcategoryData(){
        val response=apiService.getCategory()
        if (response.isSuccessful && response.body()!=null){
            _categoryData.emit(response.body()!!.distinct())
        }
    }

}