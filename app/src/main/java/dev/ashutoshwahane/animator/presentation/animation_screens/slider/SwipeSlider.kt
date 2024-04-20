package dev.ashutoshwahane.animator.presentation.animation_screens.slider

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import dev.ashutoshwahane.animator.R
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

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            UnlockSlider(isLoading = isLoading, onUnlockRequested = {
                onSwipeCta.invoke()
            },
                startIcon = painterResource(id = R.drawable.ic_heart),
                completionColor = Color.Blue,
                endIcon = painterResource(id = R.drawable.icon_butterfly),
                initialColor = Color.Red
            )


        }
    }

}