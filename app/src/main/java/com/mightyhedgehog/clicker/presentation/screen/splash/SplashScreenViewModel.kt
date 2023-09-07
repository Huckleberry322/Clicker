package com.mightyhedgehog.clicker.presentation.screen.splash

import androidx.lifecycle.viewModelScope
import com.mightyhedgehog.clicker.domain.counter.usecase.GetCounterUseCase
import com.mightyhedgehog.clicker.presentation.core.EffectiveViewModel
import com.mightyhedgehog.clicker.presentation.core.UiEffect
import com.mightyhedgehog.clicker.presentation.core.UiEvent
import com.mightyhedgehog.clicker.presentation.core.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel(
    private val getCounterUseCase: GetCounterUseCase,
) :
    EffectiveViewModel<SplashScreenViewModel.State, SplashScreenViewModel.Event,
            SplashScreenViewModel.Effect>() {

    companion object {
        private const val SplashDelay = 2500L
    }

    init {
        viewModelScope.launch {
            val counter = getCounterUseCase()

            delay(SplashDelay)
            produceEffect(Effect.NavigateToGame(counter))
        }
    }

    class State : UiState

    class Event : UiEvent

    sealed class Effect : UiEffect {
        data class NavigateToGame(val counter: Long) : Effect()
    }

    override fun createInitialState(): State = State()

    override fun onEvent(event: Event) {
        Unit
    }
}
