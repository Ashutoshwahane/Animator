package dev.ashutoshwahane.animator.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import dev.ashutoshwahane.animator.R
import dev.ashutoshwahane.animator.presentation.nav.AnimatorScreen
import dev.ashutoshwahane.animator.presentation.nav.AnimatorScreens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navHostController: NavHostController,paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
            ) {
            Text(
                text = "Animator",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
            )
            Image(
                painterResource(
                    id = R.drawable.icon_butterfly
                ),
                contentDescription = "App Icon",
                modifier = Modifier.size(30.dp)
            )
        }

        LazyColumn(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            items(AnimatorScreens) { animatorScreens ->
                AnimatorListItem(
                    animatorScreen = animatorScreens,
                    navigateToScreen = { navHostController.navigate(animatorScreens.route) })
            }
        }

    }


}


@Composable
fun AnimatorListItem(animatorScreen: AnimatorScreen, navigateToScreen: () -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
            .clickable {
                navigateToScreen.invoke()
            },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 20.dp),
        shape = MaterialTheme.shapes.small,

        ) {
        Text(
            text = animatorScreen.title,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp),
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

    }
}