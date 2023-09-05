package com.mightyhedgehog.clicker.app.di

import com.mightyhedgehog.clicker.presentation.screen.game.GameScreenModule
import com.mightyhedgehog.clicker.presentation.screen.splash.SplashScreenModule

val AppModule = listOf(
    // Screens
    SplashScreenModule,
    GameScreenModule,
)
