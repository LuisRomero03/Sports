package com.example.sports.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.sports.Components.MenuLateral
import com.example.sports.Components.TopBar

@Composable
fun HomeView(navController: NavController) {
val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    MenuLateral(navController , drawerState ) {
        ContentHomeView(drawerState)
    }
}

    @Composable
    fun ContentHomeView(drawerState: DrawerState){
Scaffold(
    topBar = {
        TopBar(drawerState = drawerState, title = "Principal" )
    }
) {
pad ->
    NotificationView(pad)
}
    }
@Composable
fun NotificationView(paddingValues: PaddingValues) {
    Column (modifier = Modifier
        .padding(paddingValues)
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
 Text(text = "Principal")
    }
}