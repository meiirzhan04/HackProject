package com.example.sxodimsduu.mainscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.sxodimsduu.R

@Composable
fun FavoriteScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF_1F1D2B))
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_qrcode),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}