package dev.ashutoshwahane.animator.presentation.animation_screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material.icons.automirrored.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.DoneOutline
import androidx.compose.material.icons.rounded.ArrowCircleRight
import androidx.compose.material.icons.rounded.SwipeRightAlt
import androidx.compose.material.icons.sharp.ArrowCircleRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import dev.ashutoshwahane.animator.R
import dev.ashutoshwahane.composeanimator.UnlockSlider
import kotlinx.coroutines.launch


@Composable
fun SwipeSlider() {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var isLoading by remember { mutableStateOf(false) }


    SwipeStatic(snackbarHostState = snackbarHostState, onSwipeCta = {
        scope.launch {
            isLoading = true

            val result = snackbarHostState
                .showSnackbar(
                    message = "Swipe Completed, Action Loading",
                    actionLabel = "Reset",

                    duration = SnackbarDuration.Long
                )
            when (result) {
                SnackbarResult.ActionPerformed -> {
                   isLoading = false
                }
                SnackbarResult.Dismissed -> {
                    isLoading = false
                }
            }
        }
    },
        isLoading = isLoading,


    )


}

@Composable
fun SwipeStatic(snackbarHostState: SnackbarHostState,onSwipeCta: () -> Unit,isLoading:Boolean) {



    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { contentPadding ->

        val imageVector = rememberVectorPainter(image = Icons.Default.DoneOutline)

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            UnlockSlider(
                isLoading = isLoading,
                onSwipeComplete = {
                    onSwipeCta.invoke()
                },
                startIcon = painterResource(id = R.drawable.ic_heart),
                completionColor = Color.LightGray,
                endIcon = painterResource(id = R.drawable.icon_butterfly),
                hintText = "Swipe to Unlock"

            )


        }
    }

}