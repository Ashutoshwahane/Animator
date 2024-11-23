package dev.ashutoshwahane.animator.presentation.animation_screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.ashutoshwahane.composeanimator.ElevatedButton


@Composable
fun ElevatedButtonAnimation() {
    var isPressed by remember { mutableStateOf(false) }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center // Centers the button in the screen
    ) {

        ElevatedButton(
            text = "Pay Now",
            onClick = { /* Handle the click event */ },
            buttonColor = Color.White,
            borderColor = Color.Gray,
            textColor = Color.Black
        )

    }
}


