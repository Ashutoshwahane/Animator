package dev.ashutoshwahane.composeanimator

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * [CircularProgressCTA] is a Jetpack Compose function that creates a button with dynamic width and height
 * transitions, along with optional circular progress and completion check mark animations.
 *
 * @param ctaText The text to be displayed on the button. Defaults to "Animator".
 * @param ctaTextStyle The style for the text on the button.
 * @param buttonWidth The initial width of the button in Density-independent Pixels (Dp).
 * @param buttonHeight The initial height of the button in Density-independent Pixels (Dp). Defaults to 50.dp.
 * @param animationSpeed The speed of the animation transitions in milliseconds. Defaults to 300.
 * @param backgroundColor The background color of the button. Defaults to Blue.
 * @param padding The padding around the button. Defaults to 16.dp.
 * @param isCompleted Indicates if the button animation is completed. Defaults to false.
 * @param drawableResource The resource ID for the drawable to be displayed upon completion.
 * @param onCTAClick The callback lambda to be invoked when the button is clicked. Defaults to an empty lambda.
 *
 * Usage:
 * ```
 * CircularProgressCTA(
 *     ctaText = "Click Me",
 *     buttonWidth = Dp(120f),
 *     buttonHeight = Dp(60f),
 *     animationSpeed = 500,
 *     backgroundColor = Color.Red,
 *     padding = 8.dp,
 *     isCompleted = true,
 *     drawableResource = R.drawable.ic_check
 * ) {
 *     // onCTAClick -> code
 * }
 * ```
 */
@Composable
fun CircularProgressCTA(
	ctaText: String = "Animator",
	ctaTextStyle: TextStyle = TextStyle(
		color = Color.White,
		fontSize = 26.sp,
		fontWeight = FontWeight.Light
	),
    buttonWidth: Dp,
    buttonHeight: Dp = 50.dp,
    animationSpeed: Int = 300,
    backgroundColor: Color = Color.Blue,
    padding: Dp = 16.dp,
    isCompleted: Boolean = false,
    drawableResource: Int,
    onCTAClick: () -> Unit
) {
	var isCircle by remember { mutableStateOf(false) }

	val width by animateDpAsState(
		targetValue = if (isCircle) 50.dp else buttonWidth, // Animate width independently
		animationSpec = tween(
			durationMillis = animationSpeed, // Adjust duration for desired speed
			easing = LinearEasing // Experiment with easing functions
		)
	)

	val height by animateDpAsState(
		targetValue = if (isCircle) 50.dp else buttonHeight, // Constant height for circle transition
		animationSpec = tween(
			durationMillis = animationSpeed, // Same duration for synchronized animation
			easing = LinearEasing // Same easing for smooth transition
		)
	)

	Box(
		modifier = Modifier
			.padding(padding)
			.clip(if (isCircle) CircleShape else RoundedCornerShape(5.dp)) // Gradual rounding
			.width(width)
			.height(height)
			.background(backgroundColor)
			.clickable {
				onCTAClick.invoke()
				isCircle = !isCircle
			}
	) {
		AnimatedVisibility(
			visible = !isCircle,
			exit = fadeOut(),
			enter = fadeIn()
		) {
			Text(
				text = ctaText,
				style = ctaTextStyle,
				modifier = Modifier.fillMaxWidth()
					.padding(4.dp),
				textAlign = TextAlign.Center,
			)
		}
		AnimatedVisibility(width == 50.dp && !isCompleted) {
			CircularProgressIndicator(
				modifier = Modifier
					.align(Alignment.Center)
					.fillMaxSize(),
				color = Color.Green
			)
		}

		AnimatedVisibility(
			visible = isCompleted && width == 50.dp,
			exit = fadeOut(),
			enter = fadeIn()
		) {
			Image(
				modifier = Modifier
					.align(Alignment.Center)
					.fillMaxSize(),
				painter = painterResource(id = drawableResource),
				contentDescription = "checked"
			)
		}
	}
}
