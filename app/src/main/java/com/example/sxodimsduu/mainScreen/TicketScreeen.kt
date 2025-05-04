package com.example.sxodimsduu.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.sxodimsduu.R

@Composable
fun TicketScreen(navController: NavHostController) {
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