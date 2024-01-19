package dev.ashutoshwahane.animator

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ButtonAnimation(modifier: Modifier = Modifier) {
    var isCircle by remember { mutableStateOf(false) }

    val mod = modifier
        .padding(20.dp)
        .fillMaxWidth()
        .height(40.dp)
        .background(Color.Green)
        .clickable { isCircle = !isCircle }
    val cir = modifier
        .clip(CircleShape)
        .size(50.dp)
        .background(Color.Blue)
        .clickable { isCircle = !isCircle }

    Box(
        modifier = if (isCircle) cir else mod
    ) {
        // Content of the button
    }
}

@Composable
fun Button1Animation(modifier: Modifier = Modifier) {
    var isCircle by remember { mutableStateOf(false) }

    val shapeModifier = if (isCircle) {
        modifier
            .clip(CircleShape)
            .size(50.dp)
    } else {
        modifier
            .padding(20.dp)
            .fillMaxWidth()
            .height(40.dp)
    }

    val shapeSize by animateDpAsState(
        targetValue = if (isCircle) 50.dp else 40.dp,
        animationSpec = tween(
            durationMillis = 4000, // Increase duration for a slower animation
            easing = LinearOutSlowInEasing // You can experiment with different easing functions
        )
    )

    Box(
        modifier = shapeModifier
            .size(shapeSize)
            .background(if (isCircle) Color.Blue else Color.Green)
            .clickable { isCircle = !isCircle }
    ) {
        // Content of the button
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Previeww() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button1Animation()
    }
}