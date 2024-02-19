package dev.ashutoshwahane.animator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.ashutoshwahane.animator.presentation.nav.NavigationCompose
import dev.ashutoshwahane.animator.ui.theme.AnimatorTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkModeOn by remember {
                mutableStateOf(false)
            }

            val systemUiController = rememberSystemUiController()

            AnimatorTheme(isDarkModeOn) {
                val statusBarColor = MaterialTheme.colorScheme.primary
                Surface {
                    Scaffold(
                        topBar = {
                            CenterAlignedTopAppBar(
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    titleContentColor = MaterialTheme.colorScheme.primary,
                                ),
                                title = {
                                    Text(text = "")
                                },
                                navigationIcon = {

                                },
                                actions = {
                                    IconButton(onClick = {
                                        isDarkModeOn = !isDarkModeOn
                                        systemUiController.setStatusBarColor(statusBarColor)
                                    }) {
                                        Icon(
                                            imageVector = if (isDarkModeOn) Icons.Default.DarkMode else Icons.Default.LightMode,
                                            contentDescription = "Localized description"
                                        )
                                    }
                                },
                            )
                        },
                    ) { paddingValues ->
                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            NavigationCompose(paddingValues)
                        }
                    }


                }
            }
        }
    }
}




