package dev.ashutoshwahane.composeanimator

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

/**
 * [BouncyCompose] is a Jetpack Compose function that creates a bouncing animation effect
 * for a provided content within a Compose UI. The animation simulates the movement of an
 * element within a defined screen area, bouncing back when reaching the boundaries.
 *
 * @param screenWidth The width of the screen in Density-independent Pixels (Dp).
 *                    Defaults to Dp(300f).
 * @param screenHeight The height of the screen in Density-independent Pixels (Dp).
 *                     Defaults to Dp(500f).
 * @param content The content to be animated. Provided as a Composable lambda.
 * @param speedXPosition The initial speed in the X direction. Defaults to 2f.
 * @param speedYPosition The initial speed in the Y direction. Defaults to 2f.
 *
 * Usage:
 * ```
 * BounceCompose(
 *     screenWidth = Dp(300f),
 *     screenHeight = Dp(500f),
 *     content = {
 *         // Your Compose UI elements go here
 *     },
 *     speedXPosition = 2f,
 *     speedYPosition = 2f
 * )
 * ```
 *
 * Example Usage in Compose:
 * ```
 * BounceCompose(
 *     content = {
 *         // Your Compose UI elements go here
 *     }
 * )
 * ```
 */
@Composable
fun BouncyCompose(
    modifier: Modifier = Modifier,
    screenWidth: Dp = Dp(300f),
    screenHeight: Dp = Dp(500f),
    content: @Composable () -> Unit,
    speedXPosition: Float = 2f,
    speedYPosition: Float = 2f

) {

    // Mutable state for X,Y positions and animation
    var positionX by remember { mutableFloatStateOf(0f) }
    var positionY by remember { mutableFloatStateOf(0f) }
    var speedX by remember { mutableFloatStateOf(speedXPosition) }
    var speedY by remember { mutableFloatStateOf(speedYPosition) }

    val animatedPositionX by animateFloatAsState(
        targetValue = positionX,
        animationSpec = infiniteRepeatable(tween(100), repeatMode = RepeatMode.Reverse),
        label = "animationPositionX"
    )

    val animatedPositionY by animateFloatAsState(
        targetValue = positionY,
        animationSpec = infiniteRepeatable(tween(100), repeatMode = RepeatMode.Reverse),
        label = "animationPositionY"
    )

    LaunchedEffect(true) {
        while (true) {
            positionX += speedX
            positionY += speedY

            // Reverse the direction if the position is reaches to screen edges
            if (positionX >= screenWidth.value || positionX <= 0f) {
                speedX *= -1
            }

            if (positionY >= screenHeight.value || positionY <= 0f) {
                speedY *= -1
            }
            // Animation delay
            delay(10)
        }
    }

    Column(
        modifier =  modifier
            .fillMaxSize(1f)
            .padding(10.dp)
    ) {

        // The Box hold the content UI and adds the animation
        Box(
            modifier = Modifier
                .offset(x = animatedPositionX.dp, y = animatedPositionY.dp)
        ) {
            content()
        }

    }
}