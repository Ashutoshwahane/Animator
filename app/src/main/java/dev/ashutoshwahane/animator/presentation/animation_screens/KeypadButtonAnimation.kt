package dev.ashutoshwahane.animator.presentation.animation_screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.ashutoshwahane.composeanimator.KeypadButton


@Composable
fun KeypadButtonAnimation() {

    Box(modifier = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center) {
        KeypadButton(
            text = "Submit",
            buttonColor = Color.White,
            shadowColor = Color.LightGray,
            borderColor = Color.Gray, // Custom border color
            onClick = {
                //CTA Login
            }
        )

    }

}







