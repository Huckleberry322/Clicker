package com.mightyhedgehog.clicker.presentation.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mightyhedgehog.clicker.presentation.core.CollectUiEffect
import com.mightyhedgehog.clicker.presentation.screen.splash.SplashScreenViewModel.*

@Composable
fun SplashScreen(
    viewModel: SplashScreenViewModel
) {

    val state by viewModel.uiState.collectAsState()

    SplashScreen(
        state = state,
        onEvent = remember { { viewModel.onEvent(it) } },
    )

    CollectUiEffect(uiEffect = viewModel.uiEffect) {

    }
}

@Composable
private fun SplashScreen(
    state: State,
    onEvent: (Event) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan))
}
