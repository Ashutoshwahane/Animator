<h1 align="center">🦋 Animator</h1></br>
<p align="center">
:butterfly: Retro Animations for Compose Android Development. Made with ❤️ for Modern Android development.
</p>

<p align="center">
<img src="https://github.com/Ashutoshwahane/Animator/assets/50887729/f27084c0-06c7-4bb5-bd5d-af028cb133ba" width="280"/>
<img src="https://github.com/Ashutoshwahane/Animator/assets/50887729/48120376-71e6-4674-b4b2-04751af47b6f" width="280"/>
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
@Composable
fun BouncyCompose(
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
@Composable
fun HeartBeatCompose(modifier: Modifier = Modifier, content: @Composable () -> Unit)
```

## 🍻 Contribute 

Contribution Guideline [contribution guidelines](CONTRIBUTING.md).

## If you find this library helpful :heart:
show some love and Support __[Animator](https://github.com/ashutoshwahane/Animator)__ . :star: <br>
Also, __[follow me](https://github.com/ashutoshwahane)__ on GitHub for my next creations! 🤩
