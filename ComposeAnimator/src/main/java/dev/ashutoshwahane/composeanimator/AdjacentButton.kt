package dev.ashutoshwahane.composeanimator

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.HapticFeedbackConstantsCompat
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * A composable function that displays a button with a 3D press effect.
 *
 * @param buttonText Optional text for the button. Defaults to "Button" if not provided.
 * @param buttonWidth Optional width for the button. If not provided, the button will fill its parent width proportionally.
 * @param buttonHeight Optional height for the button. Defaults to 80.dp if not provided.
 * @param buttonColor Background color for the button. Defaults to a light gray color (Color(0xFFEEEEEE)).
 * @param buttonForegroundColor Foreground color for the button's inner box. Defaults to white (Color(0xFFFFFFFF)).
 * @param textColor Color of the text displayed on the button. Defaults to black (Color.Black).
 * @param onClick Lambda function invoked when the button is clicked.
 */



@Composable
fun AdjacentButton(
    buttonText: String? = null, // Optional text for the button
    buttonWidth: Dp? = null, // Optional width for the button
    buttonHeight: Dp = 80.dp, // Default height for the button
    buttonColor: Color = Color(0xFFEEEEEE), // Default background color for the button
    buttonForegroundColor: Color = Color(0xFFFFFFFF),
    textColor: Color = Color.Black, // Default text color for the button
    onClick: () -> Unit // Action to perform when the button is clicked
) {
    val view = LocalView.current

    var isButtonPressed by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()

    // Animations for shadow and offset
    val buttonShadowSize by animateDpAsState(targetValue = if (isButtonPressed) 4.dp else 10.dp)
    val buttonOffsetY by animateDpAsState(targetValue = if (isButtonPressed) 4.dp else 10.dp)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(buttonHeight),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .then(
                        if (buttonWidth != null) Modifier.width(buttonWidth) else Modifier.fillMaxWidth()
                    )
                    .offset(x = 2.dp, y = buttonOffsetY)
                    .background(buttonColor, RoundedCornerShape(12.dp)) // Customizable button background color
                    .padding(5.dp)
                    .clickable(
                        indication = null, // Disable ripple effect
                        interactionSource = remember { MutableInteractionSource() } // Required to manage interactions
                    ) {
                        onClick.invoke()
                        view.performHapticFeedback(HapticFeedbackConstantsCompat.KEYBOARD_TAP)
                        scope.launch {
                            isButtonPressed = false
                            delay(150)
                            isButtonPressed = true
                        }
                    }
            ) {
                Box(
                    modifier = Modifier
                        .offset(x = -2.dp, y = -2.dp)
                        .shadow(2.dp, RoundedCornerShape(12.dp))
                        .background(buttonForegroundColor, RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = buttonText ?: "Button", // Default text if none provided
                        color = textColor, // Customizable text color
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}




