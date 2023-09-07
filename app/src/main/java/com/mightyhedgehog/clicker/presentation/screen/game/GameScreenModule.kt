package com.mightyhedgehog.clicker.presentation.screen.game

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val GameScreenModule = module {
    viewModel { (counter: Long) ->
        GameScreenViewModel(
            counter = counter,
            saveCounterUseCase = get(),
        )
    }
}
