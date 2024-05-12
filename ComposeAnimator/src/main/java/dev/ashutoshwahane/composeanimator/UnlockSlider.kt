package dev.ashutoshwahane.composeanimator

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeProgress
import androidx.compose.material.SwipeableDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import kotlin.math.roundToInt
import androidx.compose.material.SwipeableState
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable

/**
 * [UnlockSlider] is a Jetpack Compose function that creates a Swipe Slider animation effect
 * for a provided content within a Compose UI. The animation simulates swiping from start to end
 * with swiping effect
 *
 * @param isLoading Boolean for showing the loader or other icon when swiping is completed
 * @param onSwipeComplete The callback lambda to be invoked when swiping is completed.
 * @param modifier Modifier for styling and layout customization.
 * @param startIcon Slider Icon which remains, and only changes when swiping is completed
 * @param endIcon Slider Icon which is shown only when swiping is completed, default is Circular progress bar
 * @param completionColor Slider track color which is transitioned as it's complete, and completely changes when slider swiping is completed, default color is Yellow
 * @param initialColor Initial Color for slider track which is transits as slider is swiped to its completeion color
 *
 * Usage:
 * ```
 * UnlockSlider(isLoading = false, onSwipeComplete = {
 *                 // onCTAClick -> code
 *             },
 *                 startIcon = painterResource(id = R.drawable.ArrowRight),
 *             )
 * ```
 *
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UnlockSlider(
    isLoading: Boolean,
    onSwipeComplete: () -> Unit,
    modifier: Modifier = Modifier,
    hintText:String? = "",
    startIcon: Painter,
    endIcon: Painter? = null,
    completionColor: Color? = null,
    initialColor: Color? = null
) {
    val hapticFeedback = LocalHapticFeedback.current
    val swipeState = rememberSwipeableState(
        initialValue = if (isLoading) Anchor.End else Anchor.Start,
        confirmStateChange = { anchor ->
            if (anchor == Anchor.End) {
                hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                onSwipeComplete()
            }
            true
        }
    )

    val swipeFraction by remember {
        derivedStateOf { calculateSwipeFraction(swipeState.progress) }
    }

    LaunchedEffect(isLoading) {
        swipeState.animateTo(if (isLoading) Anchor.End else Anchor.Start)
    }

    Track(
        swipeState = swipeState,
        swipeFraction = swipeFraction,
        enabled = !isLoading,
        modifier = modifier,
        completionColor = completionColor,
        initialColor = initialColor
    ) {

        if (hintText != null) {
            Hint(
                text = hintText,
                swipeFraction = swipeFraction,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(PaddingValues(horizontal = Thumb.Size + 8.dp)),
            )
        }

        SwipeIcon(
            isLoading = isLoading,
            modifier = Modifier.offset {
                IntOffset(swipeState.offset.value.roundToInt(), 0)
            },
            startIcon = startIcon,
            endIcon = endIcon
        )
    }
}




@OptIn(ExperimentalMaterialApi::class)
fun calculateSwipeFraction(progress: SwipeProgress<Anchor>): Float {
    val atAnchor = progress.from == progress.to
    val fromStart = progress.from == Anchor.Start
    return if (atAnchor) {
        if (fromStart) 0f else 1f
    } else {
        if (fromStart) progress.fraction else 1f - progress.fraction
    }
}

enum class Anchor { Start, End,Middle }


fun calculateTrackColor(swipeFraction: Float, completionColor: Color, initialColor: Color): Color {
    val endOfColorChangeFraction = 0.4f
    val fraction = (swipeFraction / endOfColorChangeFraction).coerceIn(0f..1f)
    return lerp(initialColor, completionColor, fraction)
}

@Composable
fun SwipeIcon(
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    startIcon: Painter,
    endIcon: Painter?
) {
    Box(
        modifier = modifier
            .size(Thumb.Size)
            .background(color = Color.White, shape = CircleShape)
            .padding(8.dp),
    ) {
        if (isLoading) {
            if (endIcon != null) {
                Image(
                    painter = endIcon,
                    contentDescription = null,
                )
            } else {
                CircularProgressIndicator(
                    modifier = Modifier.padding(2.dp),
                    color = Color.Black,
                    strokeWidth = 2.dp
                )
            }
        } else {
            Image(
                painter = startIcon,
                contentDescription = null,
            )
        }
    }
}

@Composable
fun Hint(
    text: String,
    swipeFraction: Float,
    modifier: Modifier = Modifier,
) {
    val hintTextColor by remember(swipeFraction) {
        derivedStateOf { calculateHintTextColor(swipeFraction) }
    }

    Text(
        text = text,
        color = hintTextColor,
        style = MaterialTheme.typography.titleSmall,
        modifier = modifier
    )
}

fun calculateHintTextColor(swipeFraction: Float): Color {
    val endOfFadeFraction = 0.35f
    val fraction = (swipeFraction / endOfFadeFraction).coerceIn(0f..1f)
    return lerp(Color.White, Color.White.copy(alpha = 0f), fraction)
}


private object Thumb {
    val Size = 40.dp
}

private object Track {
    val VelocityThreshold = SwipeableDefaults.VelocityThreshold * 10
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Track(
    swipeState: SwipeableState<Anchor>,
    swipeFraction: Float,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    completionColor: Color?,
    initialColor: Color?,
    content: @Composable (BoxScope.() -> Unit),
) {
    val density = LocalDensity.current
    var fullWidth by remember { mutableIntStateOf(0) }

    val horizontalPadding = 10.dp

    val startOfTrackPx = 0f
    val endOfTrackPx = remember(fullWidth) {
        with(density) { fullWidth - (2 * horizontalPadding + Thumb.Size).toPx() }
    }

    val snapThreshold = 0.8f
    val thresholds = { from: Anchor, _: Anchor ->
        if (from == Anchor.Start) {
            FractionalThreshold(snapThreshold)
        } else {
            FractionalThreshold(1f - snapThreshold)
        }
    }

    val backgroundColor by remember(swipeFraction) {
        derivedStateOf {
            calculateTrackColor(
                swipeFraction = swipeFraction,
                completionColor = completionColor ?: Color.Yellow,
                initialColor = initialColor ?: Color.Black
            )
        }
    }

    Box(
        modifier = modifier
            .onSizeChanged { fullWidth = it.width }
            .height(56.dp)
            .fillMaxWidth()
            .swipeable(
                enabled = enabled,
                state = swipeState,
                orientation = Orientation.Horizontal,
                anchors = mapOf(
                    startOfTrackPx to Anchor.Start,
                    endOfTrackPx to Anchor.End,
                ),
                thresholds = thresholds,
                velocityThreshold = Track.VelocityThreshold,
            )
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(percent = 50),
            )
            .padding(
                PaddingValues(
                    horizontal = horizontalPadding,
                    vertical = 8.dp,
                )
            ),
        content = content,
    )
}

