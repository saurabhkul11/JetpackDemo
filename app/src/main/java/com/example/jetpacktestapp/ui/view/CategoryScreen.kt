package com.example.jetpacktestapp.ui.view

import android.graphics.fonts.FontFamily
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import com.example.jetpacktestapp.R
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpacktestapp.ui.model.MyTweets
import com.example.jetpacktestapp.ui.viewmodel.CategoryViewModel
import com.example.jetpacktestapp.ui.viewmodel.TweetsViewModel


@Composable
fun CategoryScreen(onclick: (data: String) -> Unit){
    val categoryViewModel : CategoryViewModel = hiltViewModel()
    val quotes=categoryViewModel._cdata.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround ){
        items(quotes.value){
            CategoryItem(data =it,onclick)
        }
    }

}

@Composable
fun CategoryItem(data: String,onclick:(data:String)->Unit){
    Box(contentAlignment = Alignment.Center, modifier = Modifier
        .padding(4.dp)
        .size(130.dp)
        .clickable {
            onclick(data)
        }
        .clip(RoundedCornerShape(8.dp))
        .paint(painter = painterResource(id =R.drawable.bg_img))
        //.border(2.dp, color = Color.Blue)
    ) {
        Column()
        {

                Text(
                    text = data,
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Normal,
                    color=Color.Black,
                    modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 10.dp),
                    //style = MaterialTheme.typography.body1

                )


        }
    }



}