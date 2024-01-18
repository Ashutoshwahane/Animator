package dev.ashutoshwahane.composeanimator

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp

/**
 * [HeartBeatCompose] is a Jetpack Compose function that creates a heartbeat animation effect
 * for a provided content within a Compose UI. The animation simulates the pulsation of an
 * element, expanding and contracting in size.
 *
 * @param modifier Modifier for styling and layout customization.
 * @param content The content to be animated. Provided as a Composable lambda.
 *
 * Usage:
 * ```
 * HeartBeatCompose(
 *     modifier = Modifier,
 *     content = {
 *         // Your Compose UI elements go here
 *     }
 * )
 * ```
 *
 * Example Usage in Compose:
 * ```
 * HeartBeatCompose {
 *     // Your Compose UI elements go here
 * }
 * ```
 */

@Composable
fun HeartBeatCompose(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    var scale by remember { mutableFloatStateOf(1f) }

    val infiniteTransition = rememberInfiniteTransition(label = "")

    val pulse by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    // Update scale with the pulsation value
    LaunchedEffect(pulse) {
        scale = pulse
    }

    // Box to apply the scaling effect to the content
    Box(
        modifier = modifier
            .fillMaxSize()
            .scale(scale)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}