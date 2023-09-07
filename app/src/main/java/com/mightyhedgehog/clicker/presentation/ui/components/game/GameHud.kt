package com.mightyhedgehog.clicker.presentation.ui.components.game

import android.text.format.DateUtils
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GameHud(
    onBoostPowerClick: () -> Unit,
    onDoublePowerClick: () -> Unit,
    boostTimer: Long,
    doubleTimer: Long,
    isBoostEnable: Boolean,
    isDoubleEnable: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = onBoostPowerClick,
                    enabled = isBoostEnable,
                ) {
                    Text("Power + 2")
                }
                Text(
                    text = DateUtils.formatElapsedTime(boostTimer),
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = onDoublePowerClick,
                    enabled = isDoubleEnable,
                ) {
                    Text("Power X2")
                }
                Text(
                    text = DateUtils.formatElapsedTime(doubleTimer),
                )
            }
        }
    }
}

@Preview(name = "GameHud")
@Composable
private fun PreviewGameHud() {
    GameHud(
        onBoostPowerClick = {},
        onDoublePowerClick = {},
        boostTimer = 53,
        doubleTimer = 12,
        isBoostEnable = false,
        isDoubleEnable = false,
        modifier = Modifier.fillMaxSize(),
    )
}
