package com.example.jetpacktestapp.ui.view

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.jetpacktestapp.ui.model.MyTweets
import com.example.jetpacktestapp.ui.model.Tweet
import com.example.jetpacktestapp.ui.viewmodel.QuoteViewModel
import com.example.jetpacktestapp.ui.viewmodel.TweetsViewModel

@Composable
fun TweetScreen(){
    val tweetsViewModel : TweetsViewModel = hiltViewModel()
    val quotes=tweetsViewModel._tdata.collectAsState()

    Log.d("qqq",quotes.value.toString())

   LazyColumn(){
       items(quotes.value){
           TweetsItem(data = it.text.toString())
       }
   }

}

@Composable
fun TweetsItem(data: String){
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
        border = BorderStroke(1.dp, Color.Gray),
        backgroundColor = Color(0xFFDECDF3),
        content = {
            Text(text =data ,modifier = Modifier
                .padding(16.dp),
                style = MaterialTheme.typography.body1
                )
        }
    ) 

        
    }



