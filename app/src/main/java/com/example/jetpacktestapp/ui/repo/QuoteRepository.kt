package com.example.jetpacktestapp.ui.repo

import com.example.jetpacktestapp.ui.api.ApiService
import com.example.jetpacktestapp.ui.model.Tweet
import com.example.jetpacktestapp.ui.model.MyTweets
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class QuoteRepository @Inject constructor(var apiService: ApiService) {


    var _quoteData = MutableStateFlow<List<Tweet>>(emptyList())
    val _statequoteData: StateFlow<List<Tweet>>
    get() = _quoteData
    suspend fun getQuoteData(){
        val response=apiService.getQuotes()
        if (response.isSuccessful && response.body()!=null){
            _quoteData.emit(response.body()!!.record.tweets)
        }
    }




}
