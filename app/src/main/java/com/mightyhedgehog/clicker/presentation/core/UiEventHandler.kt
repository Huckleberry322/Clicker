package com.mightyhedgehog.clicker.presentation.core

interface UiEventHandler<T : UiEvent> {
    fun onEvent(event: T)
}
