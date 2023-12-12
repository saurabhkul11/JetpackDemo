package com.example.jetpacktestapp.ui.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun HomeScreen(){
    mainNavigation()
}
@Composable
fun mainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {
        composable("category") {
            CategoryScreen(){
                navController.navigate("tweets/${it}")
            }
        }
        composable("tweets/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            ))
        {
            TweetScreen()
        }


    }
}
