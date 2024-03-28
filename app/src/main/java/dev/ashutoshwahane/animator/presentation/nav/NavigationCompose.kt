package dev.ashutoshwahane.animator.presentation.nav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.ashutoshwahane.animator.presentation.animation_screens.BouncyAnimation
import dev.ashutoshwahane.animator.presentation.animation_screens.CircularProgressAnimation
import dev.ashutoshwahane.animator.presentation.animation_screens.HeartBeatAnimation
import dev.ashutoshwahane.animator.presentation.main.MainScreen


// main navigation host
@Composable
fun NavigationCompose(paddingValues: PaddingValues) {

    Box(modifier = Modifier.fillMaxSize()) {

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "MainScreen") {
            composable("MainScreen") {
                MainScreen(navController,paddingValues)
            }
            composable("BouncyAnimation") {
                BouncyAnimation()
            }
            composable("CircularProgressAnimation") {
                CircularProgressAnimation()
            }
            composable("HeartBeatAnimation") {
                HeartBeatAnimation()
            }


        }
    }
}