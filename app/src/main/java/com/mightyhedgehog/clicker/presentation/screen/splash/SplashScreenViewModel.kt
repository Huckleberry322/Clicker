package com.mightyhedgehog.clicker.presentation.screen.splash

import androidx.lifecycle.viewModelScope
import com.mightyhedgehog.clicker.presentation.core.EffectiveViewModel
import com.mightyhedgehog.clicker.presentation.core.UiEffect
import com.mightyhedgehog.clicker.presentation.core.UiEvent
import com.mightyhedgehog.clicker.presentation.core.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel :
    EffectiveViewModel<SplashScreenViewModel.State, SplashScreenViewModel.Event,
            SplashScreenViewModel.Effect>() {

    companion object {
        private const val SplashDelay = 6000L
    }

    init {
        viewModelScope.launch {
            delay(SplashDelay)
            produceEffect(Effect.NavigateToGame)
        }
    }

    class State : UiState

    class Event : UiEvent

    sealed class Effect : UiEffect {
        data object NavigateToGame : Effect()
    }

    override fun createInitialState(): State = State()

    override fun onEvent(event: Event) {
        Unit
    }
}
