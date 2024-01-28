package dev.ashutoshwahane.animator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import dev.ashutoshwahane.animator.ui.theme.AnimatorTheme
import dev.ashutoshwahane.composeanimator.CircularProgressCTA

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			AnimatorTheme {
				val local = LocalConfiguration.current
				val xWidth = local.screenWidthDp.dp

				Column(
					modifier = Modifier
						.fillMaxSize()
						.background(Color.Black),
					verticalArrangement = Arrangement.Center,
					horizontalAlignment = Alignment.CenterHorizontally

				) {
					CircularProgressCTA(
						buttonWidth = xWidth,
						isCompleted = false,
						drawableResource = R.drawable.ic_checked_circle
					){

					}
				}
			}
		}
	}
}
