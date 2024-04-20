package dev.ashutoshwahane.animator.presentation.nav



data class AnimatorScreen(
    val route:String,
    val title:String
)


val AnimatorScreens = listOf(
    AnimatorScreen(route = "BouncyAnimation", title = "Bouncy Animation"),
    AnimatorScreen(route = "CircularProgressAnimation",title = "Circular Progress Animation"),
    AnimatorScreen(route = "HeartBeatAnimation", title = "HeartBeatAnimation"),
    AnimatorScreen(route = "SliderAnimation", title = "Slider Animation"),
)