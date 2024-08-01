package com.example.sports.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ItemsMenuLateral (
    val icon: ImageVector,
    val title: String,
    var ruta: String
){
    data object item_1 : ItemsMenuLateral(
        Icons.Default.Home,
        "Inicio",
        "Home",
    )
    data object item_2 : ItemsMenuLateral(
        Icons.Default.CheckCircle,
        "Sobre Nosotros",
        "About",
    )
    data object item_3 : ItemsMenuLateral(
        Icons.Default.AccountBox,
        "Horarios",
        "Account",
    )
}