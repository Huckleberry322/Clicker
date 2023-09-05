package com.mightyhedgehog.clicker.presentation.screen.splash

import com.mightyhedgehog.clicker.presentation.core.EffectiveViewModel
import com.mightyhedgehog.clicker.presentation.core.UiEffect
import com.mightyhedgehog.clicker.presentation.core.UiEvent
import com.mightyhedgehog.clicker.presentation.core.UiState

class SplashScreenViewModel :
    EffectiveViewModel<SplashScreenViewModel.State, SplashScreenViewModel.Event,
            SplashScreenViewModel.Effect>() {

    sealed class State : UiState {
        data object Loading : State()
    }

    sealed class Event : UiEvent

    sealed class Effect : UiEffect

    override fun createInitialState(): State = State.Loading

    override fun onEvent(event: Event) {

    }
}
