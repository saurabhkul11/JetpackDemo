package com.example.jetpacktestapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpacktestapp.ui.model.MyTweets
import com.example.jetpacktestapp.ui.repo.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(var tweetRepository: TweetRepository):ViewModel(){


    val _cdata : StateFlow<List<String>>
        get() = tweetRepository._statecategoryData


    init {
        viewModelScope.launch {
            tweetRepository.getcategoryData()
        }

    }
}