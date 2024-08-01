package com.example.sports

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import com.example.sports.Navigation.NavManager
//import com.example.sports.View.HorarioView
import com.example.sports.ui.SportsApp
import com.example.sports.ui.theme.SportsTheme
import com.google.firebase.FirebaseApp

/**
 * Aplicación Actividad para Deportes
 */
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            SportsTheme {
                val layoutDirection = LocalLayoutDirection.current
//                Surface(
//                    modifier = Modifier
//                        .padding(
//                            start = WindowInsets.safeDrawing.asPaddingValues()
//                                .calculateStartPadding(layoutDirection),
//                            end = WindowInsets.safeDrawing.asPaddingValues()
//                                .calculateEndPadding(layoutDirection)
//                        )
//                ) {
//                    SportsApp(
//                        windowSize = windowSize.widthSizeClass,
//                        onBackPressed = { finish() }
//                    ) }
                Surface(
                    modifier = Modifier
                        .padding(
                            start = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateStartPadding(layoutDirection),
                            end = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateEndPadding(layoutDirection)
                        )
                ) {
                    /*val windowSize = calculateWindowSizeClass(this)
                    SportsApp(
                        windowSize = windowSize.widthSizeClass,
                        onBackPressed = { finish() }
                    )*/ }
                NavManager()
               // HorarioView()

            }
        }
    }
}
