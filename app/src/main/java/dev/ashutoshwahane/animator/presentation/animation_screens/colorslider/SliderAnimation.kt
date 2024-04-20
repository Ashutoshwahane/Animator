package dev.ashutoshwahane.animator.presentation.animation_screens.colorslider

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.abs


@Composable
fun SliderAnimation() {

    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        ColorChangingBackgroundSlider()

    }


}


@Composable
fun ColorChangingBackgroundSlider() {
    var sliderValue by remember { mutableStateOf(0f) }

    // Define the transition
    val transition = updateTransition(targetState = sliderValue)

    // Define the color animation
    val color by transition.animateColor(
        transitionSpec = {
            tween(durationMillis = 300)
        }, label = ""
    ) { value ->
        getColorForValue(value)
    }

    // Composable to display the slider
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Background color changes according to the slider position
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color)
        )

        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, color = color),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "${color.toArgb()}", fontWeight = FontWeight.Bold, fontSize = 23.sp)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Slider
            Slider(
                value = sliderValue,
                onValueChange = { newValue ->
                    sliderValue = newValue
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(10.dp)
            )
        }


    }
}

// Function to calculate color based on slider value
private fun getColorForValue(value: Float): Color {
    val hue = (value * 360f) % 360 // Convert slider value to hue
    return hslToRgb(hue, 1f, 0.5f)
}

// Function to convert HSL to RGB
private fun hslToRgb(h: Float, s: Float, l: Float): Color {
    val c = (1f - abs(2 * l - 1)) * s
    val x = c * (1f - abs((h / 60) % 2 - 1))
    val m = l - c / 2

    val (r, g, b) = when {
        h < 60 -> Triple(c + m, x + m, m)
        h < 120 -> Triple(x + m, c + m, m)
        h < 180 -> Triple(m, c + m, x + m)
        h < 240 -> Triple(m, x + m, c + m)
        h < 300 -> Triple(x + m, m, c + m)
        else -> Triple(c + m, m, x + m)
    }

    return Color((r * 255).toInt(), (g * 255).toInt(), (b * 255).toInt())
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SliderPreview() {
    SliderAnimation()
}
