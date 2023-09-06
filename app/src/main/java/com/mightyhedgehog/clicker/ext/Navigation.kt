package com.mightyhedgehog.clicker.ext

import androidx.navigation.NavController

fun NavController.navigateSingleTop(route: String) = navigate(route) {
    launchSingleTop = true
}
