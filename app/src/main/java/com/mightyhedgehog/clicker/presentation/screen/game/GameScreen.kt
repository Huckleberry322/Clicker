package com.mightyhedgehog.clicker.presentation.screen.game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mightyhedgehog.clicker.presentation.core.CollectUiEffect
import com.mightyhedgehog.clicker.presentation.screen.game.GameScreenViewModel.*

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

}
