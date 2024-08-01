package com.example.sports.Navigation

import android.app.Activity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toComposeRect
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.window.layout.WindowMetricsCalculator
import com.example.sports.View.AboutView
import com.example.sports.View.AccountView
import com.example.sports.View.DetailView
import com.example.sports.View.HomeView
import com.example.sports.View.LoginView
import com.example.sports.View.MenuView
import com.example.sports.View.RegistroView
import com.example.sports.ViewModel.LoginViewModel
import com.example.sports.ViewModel.RegistroViewModel
import com.example.sports.helper.PreferenceHelper
import com.example.sports.ui.SportsApp
import com.google.firebase.auth.FirebaseAuth


@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MyApp.route) {
        composable(AppScreens.MyApp.route) {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val activity = LocalContext.current as? Activity
    val windowSize = activity?.let { calculateWindowSizeClass(it) }

    val currentUser = FirebaseAuth.getInstance().currentUser
    val startDestination = when {
        currentUser?.email.isNullOrEmpty() -> "login_view"
        else -> "menuView"
            }
    /*val startDestination = "MainHome"*/
    NavHost(navController, startDestination = startDestination) {
        composable("login_view") {
            val viewModelLogin: LoginViewModel = viewModel()
            LoginView(navController, viewModelLogin)
        }
        composable("form_register_view") {
            val viewModelU: RegistroViewModel = viewModel()
            RegistroView(navController, viewModelU)
        }
        composable("menuView"){
            MenuView(navController)
        }
        composable("detail_view/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")?.toInt() ?: 0
            DetailView(navController,itemId)
        }
        composable("MainHome") {
            windowSize?.let {
                SportsApp(
                    windowSize = it.widthSizeClass,
                    onBackPressed = { activity?.finish() }
                )
            }
        }
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
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun calculateWindowSizeClass(activity: Activity): WindowSizeClass {
    LocalConfiguration.current
    val density = LocalDensity.current
    val metrics = WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(activity)
    val size = with(density) { metrics.bounds.toComposeRect().size.toDpSize() }
    return WindowSizeClass.calculateFromSize(size)
}
