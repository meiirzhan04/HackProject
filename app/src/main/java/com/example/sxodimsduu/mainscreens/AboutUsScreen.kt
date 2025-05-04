package com.example.sxodimsduu.mainscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.sxodimsduu.R

@Composable
fun AboutUsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF_1F1D2B))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.sxodim),
            contentDescription = "University Logo",
            modifier = Modifier
                .size(150.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "About Us",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Our Mission",
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Connecting students with campus life through:\n" +
                    "✅ Centralized event calendar\n" +
                    "✅ Real-time notifications\n" +
                    "✅ One-tap ticket reservations",
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Features",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = "• Personalized event recommendations\n" +
                    "• Interactive campus map with venues\n" +
                    "• Group attendance tracking\n" +
                    "• Alumni networking events",
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}