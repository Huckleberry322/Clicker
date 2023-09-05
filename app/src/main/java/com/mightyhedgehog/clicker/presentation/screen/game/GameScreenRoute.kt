package com.mightyhedgehog.clicker.presentation.screen.game

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mightyhedgehog.clicker.presentation.navigation.NoArgsRoute
import com.mightyhedgehog.clicker.presentation.navigation.graph.StartGraph
import org.koin.androidx.compose.getViewModel

object GameScreenRoute : NoArgsRoute {
    override val route: String = "${StartGraph.route}/game"
}

fun NavGraphBuilder.gameDestination(navController: NavController) {
    composable(GameScreenRoute.route) { stackEntry ->
        val vm: GameScreenViewModel = getViewModel(viewModelStoreOwner = stackEntry)

        GameScreen(
            viewModel = vm,
        )
    }
}
