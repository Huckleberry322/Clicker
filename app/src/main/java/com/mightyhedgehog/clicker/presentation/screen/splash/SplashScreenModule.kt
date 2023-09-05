package com.mightyhedgehog.clicker.presentation.screen.splash

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val SplashScreenModule = module {
    viewModel {
        SplashScreenViewModel()
    }
}
