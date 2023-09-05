package com.mightyhedgehog.clicker.presentation.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.mightyhedgehog.clicker.presentation.navigation.NavRoot
import com.mightyhedgehog.clicker.presentation.navigation.Route
import com.mightyhedgehog.clicker.presentation.screen.game.GameScreenRoute
import com.mightyhedgehog.clicker.presentation.screen.game.gameDestination

object GameGraph : NavRoot<Unit> {
    override val route: String = "splash_graph"
    override val startingDestination: Route<Unit> = GameScreenRoute
}

fun NavGraphBuilder.gameGraph(
    navController: NavController,
) {
    navigation(
        startDestination = GameGraph.startingDestination.route,
        route = GameGraph.route,
    ) {
        gameDestination(navController)
    }
}
