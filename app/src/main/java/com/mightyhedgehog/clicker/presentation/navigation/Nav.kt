package com.mightyhedgehog.clicker.presentation.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry

interface NavRoot<Args> {
    val route: String
    val startingDestination: Route<Args>
    fun prepareRoute(arg: Args): String = startingDestination.prepareRoute(arg)
}

interface Route<T> {
    val route: String
    val arguments: List<NamedNavArgument>
    fun prepareRoute(arg: T): String
    fun getArgs(navBackStackEntry: NavBackStackEntry): T
}

interface NoArgsRoute : Route<Unit> {

    override val arguments: List<NamedNavArgument>
        get() = emptyList()

    override fun prepareRoute(arg: Unit): String = route

    override fun getArgs(navBackStackEntry: NavBackStackEntry): Nothing {
        throw IllegalArgumentException("There is no args")
    }
}
