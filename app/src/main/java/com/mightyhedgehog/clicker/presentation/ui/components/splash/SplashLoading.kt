package com.mightyhedgehog.clicker.presentation.ui.components.splash

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SplashLoading(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(modifier)
}

@Preview(name = "SplashLoading")
@Composable
private fun PreviewSplashLoading() {
    SplashLoading()
}
