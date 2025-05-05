package com.example.sxodimsduu.mainscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sxodimsduu.R
import com.example.sxodimsduu.mainScreen.CountdownTimer

@Composable
fun FavoriteScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF_1F1D2B))
    ) {
        Card(
            modifier = Modifier,
            shape = RoundedCornerShape(12.dp)
        ) {
            CountdownTimer()
        }
        Image(
            painter = painterResource(id = R.drawable.ic_qrcode),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}