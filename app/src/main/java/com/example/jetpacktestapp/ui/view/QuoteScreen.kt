package com.example.jetpacktestapp.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import android.R
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.jetpacktestapp.ui.model.Tweet
import com.example.jetpacktestapp.ui.viewmodel.QuoteViewModel

@Composable
fun QuotesScreen(){
    val quoteViewModel :QuoteViewModel = viewModel()
    val quotes=quoteViewModel._data.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2), 
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround ){
       items(quotes.value){
           QuotesItem(data = it)
       }
    }

}

@Composable
fun QuotesItem(data:Tweet){
    Box(modifier = Modifier
        .padding(4.dp)
        .size(150.dp)
        .clip(RoundedCornerShape(8.dp))
        //.paint(painterResource(id = R.drawable.bg_img))
        .border(2.dp, color = Color.Blue,)
    ) {
        Column()
        {
            Text(
                text =data.author,
                fontSize = 18.sp ,
                modifier = Modifier.padding(10.dp,0.dp,0.dp,10.dp),
                style = MaterialTheme.typography.body1
            )
            Image(
                painter = rememberAsyncImagePainter(data.thumbnil),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        } 
    }
    
    
    
}