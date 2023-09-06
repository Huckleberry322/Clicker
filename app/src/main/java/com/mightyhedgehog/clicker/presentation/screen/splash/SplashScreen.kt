package com.mightyhedgehog.clicker.presentation.screen.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.clicker.presentation.core.CollectUiEffect
import com.mightyhedgehog.clicker.presentation.screen.splash.SplashScreenViewModel.Effect
import com.mightyhedgehog.clicker.presentation.screen.splash.SplashScreenViewModel.Event
import com.mightyhedgehog.clicker.presentation.screen.splash.SplashScreenViewModel.State
import com.mightyhedgehog.clicker.presentation.ui.components.splash.SplashLoading
import com.mightyhedgehog.clicker.presentation.ui.components.splash.SplashLogo
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    viewModel: SplashScreenViewModel,
    navigateToGame: () -> Unit,
) {
    SplashScreen()

    CollectUiEffect(uiEffect = viewModel.uiEffect) { effect ->
        when (effect) {
            Effect.NavigateToGame -> navigateToGame()
        }
    }
}

@Composable
private fun SplashScreen(
    modifier: Modifier = Modifier,
) {
    var logoSize by remember { mutableStateOf(IntSize.Zero) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
            .onGloballyPositioned { layoutCoordinates ->
                logoSize = layoutCoordinates.size
            },
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        SplashLogo(modifier = Modifier.size((logoSize.width / 6).dp))
        SplashLoading()
    }
}
