package com.example.sports.Navigation

sealed class AppScreens(val route: String){
    object MyApp : AppScreens("main_screen")
}