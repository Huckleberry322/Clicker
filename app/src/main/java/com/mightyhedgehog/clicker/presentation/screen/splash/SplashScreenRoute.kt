package com.mightyhedgehog.clicker.presentation.screen.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mightyhedgehog.clicker.presentation.navigation.NoArgsRoute
import com.mightyhedgehog.clicker.presentation.navigation.graph.GameGraph
import com.mightyhedgehog.clicker.presentation.navigation.graph.StartGraph
import org.koin.androidx.compose.getViewModel

object SplashScreenRoute : NoArgsRoute {
    override val route: String = "${StartGraph.route}/splash"
}

fun NavGraphBuilder.splashDestination(navController: NavController) {
    composable(SplashScreenRoute.route) { stackEntry ->
        val vm: SplashScreenViewModel = getViewModel(viewModelStoreOwner = stackEntry)

        SplashScreen(
            viewModel = vm,
            onGameNavigate = { counter ->
                navController.navigate(GameGraph.prepareRoute(counter)) {
                    popUpTo(SplashScreenRoute.route) { inclusive = true }
                }
            },
        )
    }
}
