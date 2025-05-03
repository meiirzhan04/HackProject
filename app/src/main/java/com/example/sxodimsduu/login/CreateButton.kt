package com.example.sxodimsduu.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun CustomButton(
    text: String ,
    backgroundColor: Color = Color(0xFF_12CDD9)
) {
    Button(
        onClick = {

        } ,
        modifier = Modifier.fillMaxWidth() ,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = Color.White
        )
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Medium
        )
    }
}