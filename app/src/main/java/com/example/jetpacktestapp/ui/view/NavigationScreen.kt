package com.example.jetpacktestapp.ui.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class NavigationScreen : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
//            navGraphDetail()
        }
    }
}

@Composable
fun navGraphDetail(){
    val navController= rememberNavController( )

    NavHost(navController = navController, startDestination = "register"){
        composable("register"){
            registerScreen{
                navController.navigate("home/${it}")
            }
        }
        composable("login"){
            loginScreen()
        }
        composable("home/{email}", arguments = listOf(
            navArgument("email"){
                type= NavType.StringType
            }
        )){
            val email=it.arguments?.getString("email")
            if (email != null) {
                mainScreen(email)
            }
        }
    }
}



@Composable
fun registerScreen(onclick:(email:String)-> Unit){
    Text(
        text = "Register Screen",
        fontSize = 20.sp,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.wrapContentSize(Alignment.Center).clickable {
            onclick("abc123@gmail.com")
        }

    )
}

@Composable
fun loginScreen(){
    Text(
        text = "Login Screen",
        fontSize = 20.sp,
        style = MaterialTheme.typography.body1,

    )
}

@Composable
fun mainScreen(email: String){
    Text(
        text = "Home Screen: ${email}",
        fontSize = 20.sp,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.wrapContentSize(Alignment.Center)
    )
}
