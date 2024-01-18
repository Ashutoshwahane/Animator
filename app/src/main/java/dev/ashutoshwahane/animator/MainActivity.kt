package dev.ashutoshwahane.animator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.ashutoshwahane.animator.ui.theme.AnimatorTheme
import dev.ashutoshwahane.composeanimator.BouncyCompose
import dev.ashutoshwahane.composeanimator.HeartBeatCompose

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimatorTheme {
                val local = LocalConfiguration.current
                val xWidth = local.screenWidthDp.dp
                val yHeight = local.screenHeightDp.dp

                BouncyCompose(
                    modifier = Modifier.background(Color.Black),
                    screenHeight = yHeight,
                    screenWidth = xWidth,
                    content = {
                        Column {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = "",
                                modifier = Modifier.size(70.dp)
                            )
                            Text(text = "Animator", color = Color.Magenta)
                        }
                    }
                )

                /*HeartBeatCompose(
                    modifier = Modifier.background(Color.Black),
                    content = {
                        Column(
                            modifier = Modifier,
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_heart),
                                contentDescription = "",
                                modifier = Modifier.size(100.dp)
                            )
                            Text(
                                text = "Animator",
                                textAlign = TextAlign.Center,
                                color = Color.Magenta
                            )
                        }
                    })*/
            }
        }
    }
}



