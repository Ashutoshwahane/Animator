package dev.ashutoshwahane.animator.presentation.animation_screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ashutoshwahane.composeanimator.BouncyCompose


@Composable
fun BouncyAnimation() {

    val local = LocalConfiguration.current
    val xWidth = local.screenWidthDp.dp
    val xHeight = local.screenHeightDp.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        BouncyCompose(
            modifier = Modifier,
            screenWidth = Dp(350f),
            screenHeight = Dp(500f),
            speedXPosition = 2.0f,
            speedYPosition = 2.0f
        ) {
            Text(text = "BouncyAnimation", fontSize = 20.sp)
        }
    }

}
