package com.example.jetpacktestapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpacktestapp.ui.model.Tweet
import com.example.jetpacktestapp.ui.repo.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor( var repository: QuoteRepository):ViewModel() {

    val _data :StateFlow<List<Tweet>>
    get() = repository._statequoteData


    init {
        viewModelScope.launch {
            repository.getQuoteData()
        }

    }

}