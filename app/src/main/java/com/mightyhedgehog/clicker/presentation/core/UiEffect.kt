package com.mightyhedgehog.clicker.presentation.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.SharedFlow

interface UiEffect

@Composable
fun <T : UiEffect> CollectUiEffect(uiEffect: SharedFlow<T>, onEffect: (T) -> Unit) {
    LaunchedEffect(key1 = Unit) {
        uiEffect.collect {
            onEffect(it)
        }
    }
}
