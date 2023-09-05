package com.mightyhedgehog.clicker.presentation.screen.game

import com.mightyhedgehog.clicker.presentation.core.EffectiveViewModel
import com.mightyhedgehog.clicker.presentation.core.UiEffect
import com.mightyhedgehog.clicker.presentation.core.UiEvent
import com.mightyhedgehog.clicker.presentation.core.UiState

class GameScreenViewModel : EffectiveViewModel<GameScreenViewModel.State, GameScreenViewModel.Event,
        GameScreenViewModel.Effect>() {

    sealed class State : UiState {
        data object Loading : State()
    }

    sealed class Event : UiEvent

    sealed class Effect : UiEffect

    override fun createInitialState(): State = State.Loading

    override fun onEvent(event: Event) {

    }
}
