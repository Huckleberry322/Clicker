package com.mightyhedgehog.clicker.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.mightyhedgehog.clicker.presentation.navigation.NavRoot
import com.mightyhedgehog.clicker.presentation.navigation.Route
import com.mightyhedgehog.clicker.presentation.screen.game.GameScreenRoute
import com.mightyhedgehog.clicker.presentation.screen.game.gameDestination

object GameGraph : NavRoot<Long> {
    override val route: String = "game_graph"
    override val startingDestination: Route<Long> = GameScreenRoute
}

fun NavGraphBuilder.gameGraph() {
    navigation(
        startDestination = GameGraph.startingDestination.route,
        route = GameGraph.route,
    ) {
        gameDestination()
    }
}
