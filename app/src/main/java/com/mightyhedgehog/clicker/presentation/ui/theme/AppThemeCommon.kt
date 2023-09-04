package com.mightyhedgehog.clicker.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.mightyhedgehog.clicker.presentation.ui.theme.values.colors.ColorCommon
import com.mightyhedgehog.clicker.presentation.ui.theme.values.dimens.DimensCommon
import com.mightyhedgehog.clicker.presentation.ui.theme.values.typography.TypographyCommon

const val ColorProviderError = "No colors provided"
const val FontProviderError = "No fonts provided"
const val DimensProviderError = "No dimens provided"

object AppTheme {
    val colors: ColorCommon
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val fonts: TypographyCommon
        @Composable
        @ReadOnlyComposable
        get() = LocalAppFonts.current

    val dimens: DimensCommon
        @Composable
        @ReadOnlyComposable
        get() = LocalAppDimens.current
}

val LocalAppColors = staticCompositionLocalOf<ColorCommon> {
    error(ColorProviderError)
}

val LocalAppFonts = staticCompositionLocalOf<TypographyCommon> {
    error(FontProviderError)
}

val LocalAppDimens = staticCompositionLocalOf<DimensCommon> {
    error(DimensProviderError)
}
