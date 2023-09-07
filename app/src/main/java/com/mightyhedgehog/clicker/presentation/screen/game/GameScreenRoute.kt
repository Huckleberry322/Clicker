package com.mightyhedgehog.clicker.presentation.screen.game

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mightyhedgehog.clicker.presentation.navigation.Route
import com.mightyhedgehog.clicker.presentation.navigation.graph.GameGraph
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

object GameScreenRoute : Route<Long> {

    private const val CounterArgumentName = "counter_arg"

    private val routeWithoutArguments = "${GameGraph.route}/game"

    override val route: String = "$routeWithoutArguments/{$CounterArgumentName}"

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(CounterArgumentName) { type = NavType.LongType }
        )

    override fun getArgs(navBackStackEntry: NavBackStackEntry): Long {
        val arguments = navBackStackEntry.arguments!!
        return arguments.getLong(CounterArgumentName)
    }

    override fun prepareRoute(arg: Long): String =
        "$routeWithoutArguments/${arg}"

}

fun NavGraphBuilder.gameDestination() {
    composable(
        route = GameScreenRoute.route,
        arguments = GameScreenRoute.arguments,
    ) { stackEntry ->
        val gameScreenArg = GameScreenRoute.getArgs(stackEntry)
        val vm: GameScreenViewModel = getViewModel(viewModelStoreOwner = stackEntry) {
            parametersOf(gameScreenArg)
        }

        GameScreen(
            viewModel = vm,
        )
    }
}
