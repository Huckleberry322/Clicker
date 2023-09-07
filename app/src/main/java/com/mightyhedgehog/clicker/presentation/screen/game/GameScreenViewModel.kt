package com.mightyhedgehog.clicker.presentation.screen.game

import androidx.lifecycle.viewModelScope
import com.mightyhedgehog.clicker.domain.counter.usecase.SaveCounterUseCase
import com.mightyhedgehog.clicker.presentation.core.EffectiveViewModel
import com.mightyhedgehog.clicker.presentation.core.UiEffect
import com.mightyhedgehog.clicker.presentation.core.UiEvent
import com.mightyhedgehog.clicker.presentation.core.UiState
import com.mightyhedgehog.clicker.presentation.screen.game.model.ClickPower
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class GameScreenViewModel(
    private val initialPower: ClickPower = ClickPower(1),
    private val counter: Long,
    private val saveCounterUseCase: SaveCounterUseCase,
) : EffectiveViewModel<GameScreenViewModel.State, GameScreenViewModel.Event,
        GameScreenViewModel.Effect>() {

    private var timerBoostJob: Job? = null
    private var timerDoubleJob: Job? = null

    data class State(
        val counter: Long,
        val currentPower: ClickPower,
        val doubleTimerValue: Long = 0,
        val boostTimerValue: Long = 0,
    ) : UiState

    sealed class Event : UiEvent {
        data object Click : Event()
        data object DoublePowerRequest : Event()
        data object BoostPowerRequest : Event()
        data object ScreenPause : Event()
    }

    sealed class Effect : UiEffect

    override fun createInitialState(): State = State(
        counter = counter,
        currentPower = initialPower,
    )

    override fun onEvent(event: Event) {
        when (event) {
            Event.Click -> increaseCounter(state.currentPower.value)
            Event.BoostPowerRequest -> turnOnBoostPower()
            Event.DoublePowerRequest -> turnOnDoublePower()
            Event.ScreenPause -> saveCounter(state.counter)
        }
    }

    private fun turnOnDoublePower() {
        produceState(state.copy(doubleTimerValue = 60L))
        startDoubleTimer()
    }

    private fun turnOnBoostPower() {
        increasePower(state.currentPower.value + 2)
        startBoostTimer()
    }

    private fun startDoubleTimer() {
        timerDoubleJob = viewModelScope.launch(Dispatchers.Default) {
            while (state.doubleTimerValue != 0L) {
                delay(TimeUnit.SECONDS.toMillis(1))
                produceState(state.copy(doubleTimerValue = state.doubleTimerValue - 1L))
            }
        }
    }

    private fun startBoostTimer() {
        timerBoostJob = viewModelScope.launch(Dispatchers.Default) {
            while (state.boostTimerValue != 0L) {
                delay(TimeUnit.SECONDS.toMillis(1))
                produceState(state.copy(boostTimerValue = state.boostTimerValue - 1L))
            }
            decreasePower()
        }
    }

    private fun saveCounter(counter: Long) {
        saveCounterUseCase.invoke(counter)
    }

    private fun increaseCounter(plusValue: Long) {
        val countedPlusValue = if (state.doubleTimerValue == 0L) plusValue else plusValue * 2
        val newValue = state.counter + countedPlusValue
        produceState(state.copy(counter = newValue))
    }

    private fun increasePower(newPowerValue: Long) {
        produceState(state.copy(currentPower = ClickPower(newPowerValue), boostTimerValue = 60L))
    }

    private fun decreasePower() = produceState(state.copy(currentPower = initialPower))
}
