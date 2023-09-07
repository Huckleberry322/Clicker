package com.mightyhedgehog.clicker.presentation.ui.theme.values.colors

import androidx.compose.ui.graphics.Color

val lightPalette = ColorCommon(
    mainColor = ColorPalette.White
)

val darkPalette = lightPalette.copy()

object ColorPalette {
    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF111111)
}
