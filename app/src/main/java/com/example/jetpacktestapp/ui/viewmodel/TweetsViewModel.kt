package com.example.jetpacktestapp.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpacktestapp.ui.model.MyTweets
import com.example.jetpacktestapp.ui.model.Tweet
import com.example.jetpacktestapp.ui.repo.QuoteRepository
import com.example.jetpacktestapp.ui.repo.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(var repository: TweetRepository,var savedStateHandle: SavedStateHandle): ViewModel() {

    val _tdata : StateFlow<List<MyTweets>>
    get() = repository._statetweetData


    init {
        viewModelScope.launch {
            val cat=savedStateHandle.get<String>("category")?:"android"
            repository.getTweetData(cat)
        }
    }

}