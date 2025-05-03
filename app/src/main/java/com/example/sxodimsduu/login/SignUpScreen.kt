package com.example.sxodimsduu.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpScreen() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF_1F1D2B)),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign Up",
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
            letterSpacing = 0.5.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 64.dp),
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Let’s get started",
            fontSize = 24.sp,
            fontWeight = FontWeight.W600,
            letterSpacing = 0.5.sp,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "The latest movies and series are here",
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            letterSpacing = 0.5.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(72.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            placeholder = {
                Text(
                    text = "Full Name",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF_EBEBEF)
                )
            },
            shape = RoundedCornerShape(24.dp),
        )
    }
}