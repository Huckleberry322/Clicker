package com.mightyhedgehog.clicker.presentation.ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.clicker.presentation.ui.theme.values.colors.darkPalette
import com.mightyhedgehog.clicker.presentation.ui.theme.values.colors.lightPalette
import com.mightyhedgehog.clicker.presentation.ui.theme.values.dimens.phoneDimens
import com.mightyhedgehog.clicker.presentation.ui.theme.values.dimens.tabletDimens
import com.mightyhedgehog.clicker.presentation.ui.theme.values.typography.typography

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun ClickerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    windowSizeClass: WindowSizeClass = WindowSizeClass.calculateFromSize(
        DpSize(width = 500.dp, height = 800.dp)
    ),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) darkPalette else lightPalette
    val fonts = typography
    val dimens = if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
        phoneDimens
    } else tabletDimens

    val rippleIndication = rememberRipple()

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppFonts provides fonts,
        LocalAppDimens provides dimens,
        LocalIndication provides rippleIndication,
        LocalRippleTheme provides AppRippleTheme,
        content = content
    )
}
