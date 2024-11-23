<h1 align="center">🦋 Animator</h1></br>
<p align="center">
:butterfly: Retro Animations for Compose Android Development. Made with ❤️ for Modern Android development.
</p>

<p align="center">
<img src="https://github.com/Ashutoshwahane/Animator/assets/50887729/f27084c0-06c7-4bb5-bd5d-af028cb133ba" width="280"/>
<img src="https://github.com/Ashutoshwahane/Animator/assets/50887729/48120376-71e6-4674-b4b2-04751af47b6f" width="280"/>
<img src="https://github.com/Ashutoshwahane/Animator/assets/50887729/dbce2ac3-fac4-4184-8acc-14f780b8a8d8" width="280"/>
<img src="https://raw.githubusercontent.com/yeshuwahane/Animator/main/screenshots/swipeanimation.gif" width="280"/>

<img src="https://raw.githubusercontent.com/yeshuwahane/Animator/refs/heads/main/screenshots/typewriterBUtton.gif" width="280"/>

<img src="https://raw.githubusercontent.com/yeshuwahane/Animator/refs/heads/main/screenshots/parallaxButton.gif" width="280"/>

<img src="https://raw.githubusercontent.com/yeshuwahane/Animator/refs/heads/main/screenshots/keypadButton.gif" width="280"/>

</p>



## 👨🏽‍💻 Implementation
You can check app directory which includes example application for demonstration.

### 🚀 Gradle setup
In `setting.gradle.kts` include this dependency
```gradle
dependencyResolutionManagement {
    repositories {
        maven ("https://jitpack.io")
    }
}
```

Now In build.gradle.kts include this dependency

```gradle
 implementation("com.github.Ashutoshwahane:Animator:0.3-beta")
```


## How to Use

BouncyCompose is a Jetpack Compose function that creates a bouncing animation effect for a provided content within a Compose UI. The animation simulates the movement of an element within a defined screen area, bouncing back when reaching the boundaries.

```kotlin
val local = LocalConfiguration.current
val xWidth = local.screenWidthDp.dp
val xHeight = local.screenHeightDp.dp
BouncyCompose(
    modifier: Modifier = Modifier, 
    screenWidth: Dp = Dp(300f), 
    screenHeight: Dp = Dp(500f), 
    content: @Composable () -> Unit, 
    speedXPosition: Float = 2.0f, 
    speedYPosition: Float = 2.0f
)
```


HeartBeatCompose is a Jetpack Compose function that creates a heartbeat animation effect for a provided content within a Compose UI. The animation simulates the pulsation of an element, expanding and contracting in size.
```kotlin
val local = LocalConfiguration.current
val xWidth = local.screenWidthDp.dp
val xHeight = local.screenHeightDp.dp
HeartBeatCompose(modifier: Modifier = Modifier, content: @Composable () -> Unit)
```


CircularProgressCTA is a Jetpack Compose function that creates a button with dynamic width and height transitions, along with optional circular progress and completion check mark animations.
```kotlin
val local = LocalConfiguration.current
val xWidth = local.screenWidthDp.dp
CircularProgressCTA(
    buttonWidth = xWidth,
    isCompleted = false,
    drawableResource = R.drawable.ic_checked_circle
    ){
        // Handle CTA Click
    }
```

SwipingSliderCTA Swipe seamlessly from start to end with intuitive interface. As you swipe, the icon gracefully moves, and the track changes color to guide your progress. With built-in lambda functions, you can effortlessly integrate custom actions or code snippets

```kotlin
UnlockSlider(
                isLoading = isLoading,
                onSwipeComplete = {
                    //Handle CTA 
                },
                startIcon = painterResource(id = R.drawable.ic_heart),
                completionColor = Color.LightGray,
                endIcon = painterResource(id = R.drawable.icon_butterfly),
                hintText = "Swipe to Unlock"

            )
```


Button looks and have effect like Typewriter button. With built-in lambda functions, you can effortlessly integrate custom actions or code snippets

```kotlin
AdjacentButton(
            buttonText = "Submit",
            buttonWidth = 200.dp,
            buttonColor = Color.Gray, // Custom purple color
            textColor = Color.Black, // Custom white text color,
            buttonForegroundColor = Color.White
        ) {
            println("Button clicked!")
        }
```


Button with shimmer effect, where you can select color for shimmer with three colors . With built-in lambda functions, you can effortlessly integrate custom actions or code snippets

```kotlin
ShimmerButton(
            text = "Play now →",
            onClick = { /* Handle button click */ },
            shimmerColors = listOf(Color.White, Color.Gray, Color.White),
            shadowColor = Color.DarkGray
        )
```


Button like keyboard button . With built-in lambda functions, you can effortlessly integrate custom actions or code snippets

```kotlin
ElevatedButton(
            text = "Pay Now",
            onClick = { /* Handle the click event */ },
            buttonColor = Color.White,
            borderColor = Color.Gray,
            textColor = Color.Black
        )
```



Button animation like keypad . With built-in lambda functions, you can effortlessly integrate custom actions or code snippets

```kotlin
KeypadButton(
            text = "Submit",
            buttonColor = Color.White,
            shadowColor = Color.LightGray,
            borderColor = Color.Gray, // Custom border color
            onClick = {
                //CTA Login
            }
        )
```





## 🍻 Contribute 

Contribution Guideline [contribution guidelines](CONTRIBUTING.md).

## If you find this library helpful :heart:
show some love and Support __[Animator](https://github.com/ashutoshwahane/Animator)__ . :star: <br>
Also, __[follow me](https://github.com/ashutoshwahane)__ on GitHub for my next creations! 🤩
