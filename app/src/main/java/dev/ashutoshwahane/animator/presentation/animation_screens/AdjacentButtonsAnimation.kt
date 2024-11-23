package dev.ashutoshwahane.animator.presentation.animation_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.ashutoshwahane.composeanimator.AdjacentButton

@Composable
fun AdjacentButtonsAnimation() {

    Box(modifier = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center){

        AdjacentButton(
            buttonText = "Submit",
            buttonWidth = 200.dp,
            buttonColor = Color.Gray, // Custom purple color
            textColor = Color.Black, // Custom white text color,
            buttonForegroundColor = Color.White
        ) {
            println("Button clicked!")
        }



    }

}

