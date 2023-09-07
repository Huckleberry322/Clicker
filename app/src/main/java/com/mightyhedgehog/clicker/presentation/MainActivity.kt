package com.mightyhedgehog.clicker.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mightyhedgehog.clicker.presentation.navigation.AppNavigation
import com.mightyhedgehog.clicker.presentation.navigation.graph.StartGraph
import com.mightyhedgehog.clicker.presentation.ui.theme.ClickerTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(activity = this)
            val navController = rememberNavController()

            ClickerTheme(windowSizeClass = windowSizeClass) {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    AppNavigation(
                        startDestination = StartGraph.route,
                        navController = navController,
                    )
                }
            }
        }
    }
}
