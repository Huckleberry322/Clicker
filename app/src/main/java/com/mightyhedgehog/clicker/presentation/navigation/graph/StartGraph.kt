package com.mightyhedgehog.clicker.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.mightyhedgehog.clicker.presentation.navigation.NavRoot
import com.mightyhedgehog.clicker.presentation.navigation.Route
import com.mightyhedgehog.clicker.presentation.screen.splash.SplashScreenRoute
import com.mightyhedgehog.clicker.presentation.screen.splash.splashDestination

object StartGraph : NavRoot<Unit> {
    override val route: String = "start_graph"
    override val startingDestination: Route<Unit> = SplashScreenRoute
}

fun NavGraphBuilder.startGraph(
    navController: NavHostController,
) {
    navigation(
        startDestination = StartGraph.startingDestination.route,
        route = StartGraph.route,
    ) {
        splashDestination(navController)
    }
}
