package dev.ashutoshwahane.animator.presentation.animation_screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ashutoshwahane.animator.R
import dev.ashutoshwahane.composeanimator.HeartBeatCompose


@Composable
fun HeartBeatAnimation() {

    val local = LocalConfiguration.current
    val xWidth = local.screenWidthDp.dp
    val xHeight = local.screenHeightDp.dp
    HeartBeatCompose(modifier = Modifier) {
        Icon(painterResource(id = R.drawable.ic_heart), contentDescription = " ")
    }
}