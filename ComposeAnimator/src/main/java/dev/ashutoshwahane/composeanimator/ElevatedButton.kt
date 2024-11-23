package dev.ashutoshwahane.composeanimator

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.HapticFeedbackConstantsCompat
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * A customizable Elevated Button with animation and haptic feedback.
 *
 * @param text The text to display on the button. Defaults to "Click Me".
 * @param onClick The action to be executed when the button is clicked.
 * @param modifier A [Modifier] for styling and layout adjustments.
 * @param buttonColor The background color of the button. Defaults to [Color.Black].
 * @param borderColor The color of the button border. Defaults to greenish color [0xFF7DBA50].
 * @param textColor The text color of the button. Defaults to [Color.White].
 */


@Composable
fun ElevatedButton(
    text: String = "Click Me", // The text displayed on the button
    onClick: () -> Unit,       // Click event handler
    modifier: Modifier = Modifier, // Modifier for custom styling
    buttonColor: Color = Color.Black, // Button background color
    borderColor: Color = Color(0xFF7DBA50), // Border color
    textColor: Color = Color.White, // Text color
) {
    // State to handle button press animation
    var isPressed by remember { mutableStateOf(true) }

    // Animate shadow and offset to create a press and release effect
    val shadowSize by animateDpAsState(targetValue = if (isPressed) 0.dp else 10.dp, animationSpec = tween(150))
    val offsetY by animateDpAsState(targetValue = if (isPressed) 0.dp else 6.dp, animationSpec = tween(150))

    val view = LocalView.current
    val scope = rememberCoroutineScope()

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .shadow(shadowSize, RoundedCornerShape(12.dp), clip = false)
                .offset(y = offsetY)
                .clickable {
                    // Haptic feedback and button press animation
                    view.performHapticFeedback(HapticFeedbackConstantsCompat.KEYBOARD_TAP)

                    scope.launch {
                        isPressed = false  // Start the press animation
                        delay(150)  // Short delay to simulate press effect
                        isPressed = true  // Release the button
                        onClick()  // Trigger the onClick event
                    }
                }
        ) {
            Box(
                modifier = Modifier
                    .border(3.dp, borderColor, RoundedCornerShape(12.dp))
                    .background(buttonColor, RoundedCornerShape(12.dp))
                    .fillMaxWidth(0.85f)
                    .height(60.dp)
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    color = textColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

