package com.mightyhedgehog.clicker.presentation.screen.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import com.mightyhedgehog.clicker.ext.LifecycleEventEffect
import com.mightyhedgehog.clicker.presentation.core.CollectUiEffect
import com.mightyhedgehog.clicker.presentation.screen.game.GameScreenViewModel.Event
import com.mightyhedgehog.clicker.presentation.screen.game.GameScreenViewModel.State
import com.mightyhedgehog.clicker.presentation.ui.components.game.GameHud

@Composable
fun GameScreen(
    viewModel: GameScreenViewModel
) {

    val state by viewModel.uiState.collectAsState()

    GameScreen(
        state = state,
        onEvent = remember { { viewModel.onEvent(it) } },
    )

    CollectUiEffect(uiEffect = viewModel.uiEffect) {

    }
}

@Composable
private fun GameScreen(
    state: State,
    onEvent: (Event) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        GameHud(
            onBoostPowerClick = { onEvent(Event.BoostPowerRequest) },
            onDoublePowerClick = { onEvent(Event.DoublePowerRequest) },
            boostTimer = state.boostTimerValue,
            doubleTimer = state.doubleTimerValue,
            isBoostEnable = state.boostTimerValue == 0L,
            isDoubleEnable = state.doubleTimerValue == 0L,
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = 50.dp,
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = state.counter.toString(),
                style = TextStyle(fontSize = 24.sp),
            )
            Button(onClick = { onEvent(Event.Click) }) {
                Text("Click")
            }
        }
    }

    LifecycleEventEffect { _, event ->
        when (event) {
            Lifecycle.Event.ON_PAUSE -> onEvent(Event.ScreenPause)
            else -> Unit
        }
    }
}
