package com.example.sxodimsduu.mainscreens

import android.R.attr.bottom
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun LegalAndPoliciesScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF_1F1D2B))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Legal and Policies",
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Terms of Service",
            color = Color.White,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "By using UniEvents, you agree to:\n" +
                    "• Use the app only for legitimate university event purposes\n" +
                    "• Not resell or transfer event tickets for profit\n" +
                    "• Abide by your university's code of conduct",
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Privacy Policy",
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
        )
        Spacer(modifier = Modifier.height(24.dp))


        Text(
            text = "We collect:\n" +
                    "• Basic profile information to verify student status\n" +
                    "• Event preferences to personalize recommendations\n" +
                    "• Device information for notification delivery",
            color = Color.White,
            fontWeight = FontWeight.Medium,
        )
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Contact",
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "For legal inquiries: legal@unievents.edu\n" +
                    "Last updated: May 04, 2025",
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
    }
}