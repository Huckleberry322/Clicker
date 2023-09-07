package com.mightyhedgehog.clicker.app.di

import com.mightyhedgehog.clicker.data.di.RepositoryModule
import com.mightyhedgehog.clicker.domain.counter.di.UseCaseModule
import com.mightyhedgehog.clicker.presentation.screen.game.GameScreenModule
import com.mightyhedgehog.clicker.presentation.screen.splash.SplashScreenModule

val AppModule = listOf(
    // Screens
    SplashScreenModule,
    GameScreenModule,
    // Data
    RepositoryModule,
    // Domain
    UseCaseModule,
)
