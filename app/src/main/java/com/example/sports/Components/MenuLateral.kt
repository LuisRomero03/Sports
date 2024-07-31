package com.example.sports.Components

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun MenuLateral(
    navController: NavController,
    drawerState: DrawerState,
    content: @Composable () -> Unit

) {
  val scope = rememberCoroutineScope()

}