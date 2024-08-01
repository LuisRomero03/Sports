package com.example.sports.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sports.View.AboutView
import com.example.sports.View.AccountView
import com.example.sports.View.HomeView

@Composable
fun NavManager () {
    //OLayo Cambios
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable( "Home"){
            HomeView(navController)
    }
        composable( "About"){
            AboutView()
    }
        composable("Account"){
            AccountView()
    }
    }
    }
