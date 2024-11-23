package dev.ashutoshwahane.composeanimator

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
/**
 * [KeypadButton] creates a customizable 3D button with an animated press effect.
 *
 * @param text The text to be displayed inside the button. Defaults to "Click Me".
 * @param onClick The action to be executed when the button is clicked.
 * @param modifier The [Modifier] to be applied to the button container.
 * @param buttonColor The color of the button. Defaults to [Color.White].
 * @param shadowColor The color of the shadow behind the button. Defaults to [Color.DarkGray].
 * @param borderColor The color of the button's border. Defaults to [Color.Gray].
 */
@Composable
fun KeypadButton(
    text: String = "Click Me",
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonColor: Color = Color.White,
    shadowColor: Color = Color.DarkGray,
    borderColor: Color = Color.Gray // New parameter for border color
) {
    var isPressed by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    // Animate button movement and shadow based on press state
    val buttonOffsetY by animateDpAsState(targetValue = if (isPressed) 6.dp else 0.dp)
    val bottomShadowOffsetY by animateDpAsState(targetValue = if (isPressed) 10.dp else 4.dp)
    val shadowHeight by animateDpAsState(targetValue = if (isPressed) 2.dp else 6.dp)
    val buttonBackgroundColor by animateColorAsState(
        targetValue = if (isPressed) Color.Gray else buttonColor
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Bottom shadow (shown behind the button)
        Spacer(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(shadowHeight)
                .offset(y = bottomShadowOffsetY)
                .background(
                    shadowColor,
                    shape = CutCornerShape(
                        topStart = 0.dp, topEnd = 0.dp, bottomStart = 12.dp, bottomEnd = 12.dp
                    )
                )
        )

        // Main button container
        Box(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(60.dp)
                .offset(y = buttonOffsetY)
                .background(
                    buttonBackgroundColor,
                    shape = CutCornerShape(
                        topStart = 0.dp, topEnd = 0.dp, bottomStart = 6.dp, bottomEnd = 6.dp
                    )
                )
                .border(
                    2.dp, borderColor, // Apply the customizable border color
                    shape = CutCornerShape(
                        topStart = 0.dp, topEnd = 0.dp, bottomStart = 2.dp, bottomEnd = 2.dp
                    )
                )
                .clickable {
                    isPressed = true
                    scope.launch {
                        delay(150) // Press animation timing
                        isPressed = false
                        onClick() // Execute the provided onClick action
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            // Text inside the button
            Text(
                text = text,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}
