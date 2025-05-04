package com.example.sxodimsduu.mainscreens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sxodimsduu.login.CustomButton
import java.text.SimpleDateFormat
import java.util.Date

@Preview
@Composable
fun HelpScreen() {
    val context = LocalContext.current
    var feedbackText by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF_1F1D2B))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Help & Feedback",
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Getting Started",
            color = Color.White,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "1. Verify your student email to access events\n" +
                    "2. Browse upcoming events by category\n" +
                    "3. Tap \"Attend\" to reserve your spot",
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Common Issues",
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
        )
        Spacer(modifier = Modifier.height(24.dp))


        Text(
            text = "🔹 Can't verify email?\nCheck your university portal for approval\n\n" +
                    "🔹 Ticket not showing?\nAllow 5 minutes for processing\n\n" +
                    "🔹 Event full?\nJoin waitlist - 65% get in from waitlists",
            color = Color.White,
            fontWeight = FontWeight.Medium,
        )
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Send Feedback",
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = feedbackText,
            onValueChange = { feedbackText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            placeholder = { Text("Your suggestions...") },
            maxLines = 3,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedBorderColor = Color(0xFF_B1B1B1),
                unfocusedTextColor = Color(0xFF_B1B1B1)
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton(text = "Send Feedback", Color(0xFF_FF8700), onClick = {feedbackText = ""})
    }
}