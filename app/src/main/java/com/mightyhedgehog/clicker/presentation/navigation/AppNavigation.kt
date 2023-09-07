package com.mightyhedgehog.clicker.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mightyhedgehog.clicker.presentation.navigation.graph.gameGraph
import com.mightyhedgehog.clicker.presentation.navigation.graph.startGraph

@ExperimentalAnimationApi
@Composable
fun AppNavigation(
    startDestination: String,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            fadeIn(animationSpec = tween(350))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(350))
        },
    ) {
        startGraph(navController)
        gameGraph()
    }
}
