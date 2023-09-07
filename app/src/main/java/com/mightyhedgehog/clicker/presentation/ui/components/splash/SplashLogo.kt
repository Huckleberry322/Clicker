package com.mightyhedgehog.clicker.presentation.ui.components.splash

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mightyhedgehog.clicker.R

@Composable
fun SplashLogo(
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.splash_logo),
        contentDescription = null,
        modifier = modifier,
        tint = Color.Green,
    )
}

@Preview(name = "SplashLogo")
@Composable
private fun PreviewSplashLogo() {
    SplashLogo()
}
