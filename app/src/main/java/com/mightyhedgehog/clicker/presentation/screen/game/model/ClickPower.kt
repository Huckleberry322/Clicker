package com.mightyhedgehog.clicker.presentation.screen.game.model

@JvmInline
value class ClickPower(val value: Long) {

    companion object {
        const val MinClickPower = 1L
    }

    init {
        require(value in MinClickPower..Long.MAX_VALUE)
    }
}
