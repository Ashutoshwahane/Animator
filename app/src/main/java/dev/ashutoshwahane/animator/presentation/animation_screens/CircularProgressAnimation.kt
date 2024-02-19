package dev.ashutoshwahane.animator.presentation.animation_screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Laptop
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ashutoshwahane.animator.R
import dev.ashutoshwahane.composeanimator.CircularProgressCTA


@Composable
fun CircularProgressAnimation() {

    val local = LocalConfiguration.current
    val xWidth = local.screenWidthDp.dp
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressCTA(
            buttonWidth = xWidth,
            isCompleted = false,
            drawableResource = R.drawable.ic_checked_circle,
            padding = 10.dp
        ) {

        }
    }


}