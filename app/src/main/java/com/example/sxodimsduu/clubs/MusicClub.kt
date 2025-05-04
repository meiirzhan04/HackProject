package com.example.sxodimsduu.clubs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sxodimsduu.R
import com.example.sxodimsduu.data.Screen
import com.example.sxodimsduu.login.CustomButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicScreen(navController: NavHostController) {
    var showForgotPasswordSheet by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState()
    if (showForgotPasswordSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showForgotPasswordSheet = false
            },
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            containerColor = Color(0xFF_1F1D2B),
            sheetState = sheetState,
            scrimColor = Color.Black.copy(alpha = 0.5f),
            dragHandle = {
                CustomDragHandle()
            },
            content = {
                LazyColumn(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    item {
                        androidx.compose.material3.Text(
                            text = "Choose the way of Payment",
                            color = Color.White,
                            fontSize = 24.sp,
                            lineHeight = 32.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        ForgotPasswordBoxes(
                            image = R.drawable.ic_kaspi,
                            title = "Kaspi Pay",
                            subtitle = "asdsdas",
                            selectedMethod = {}
                        )
                        ForgotPasswordBoxes(
                            image = R.drawable.ic_wallet,
                            title = "Cash",
                            subtitle = "asdsdas",
                            selectedMethod = {}
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            shape = RoundedCornerShape(100.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFE8C00))
                        ) {
                            Text(
                                text = "Continue"
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        )
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.open_air_music),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .padding(24.dp)
                        .padding(vertical = 24.dp)
                        .size(32.dp)
                        .clickable(
                            onClick = {

                                navController.popBackStack()
                            },
                            indication = ripple(bounded = true),
                            interactionSource = null
                        )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                        .align(Alignment.BottomStart),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF_111827))
                    .clip(shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .padding(24.dp)
            ) {
                Text(
                    text = "Open Air",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "25.04.2025  |  18:30  |  SDU Life Scene",
                    color = Color(0xFF_9CA3AF),
                )
                HorizontalDivider(
                    color = Color(0xFF_1C2431),
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 24.dp)
                )
                Text(
                    text = "Yo-yo, SDUdents! \uD83D\uDC99\n" +
                            "\n" +
                            "With the warm days of spring comes the most atmospheric evening of this season! We invite you to a bright open-air event that will give you an unforgettable atmosphere, lots of emotions and a real spring vibe! \uD83C\uDFB6\n" +
                            "\n" +
                            "Together with our friends from @musicclubsdu, I hope that these were the best songs, warmth and music for you! Open–air music, emotions that will stay in your heart - all this is at our event!\uD83D\uDD25\n" +
                            "\n" +
                            "Live performances and favorite hits, energetic presenters, delicious food and an atmosphere of complete relaxation are waiting for you!\uD83D\uDCA5\n" +
                            "\n" +
                            "Don't miss this evening! Invite your friends and get ready to sing with us! \uD83C\uDFB8",
                    color = Color(0xFF_E5E7EB),
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    letterSpacing = 0.5.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Text(
                        text = "Organizers:",
                        color = Color(0xFF_4B5563)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Music club",
                        color = Color(0xFF_9CA3AF)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                CustomButton(
                    "Get Ticket",
                    Color(0xFF_FF8700),
                    onClick = {
                        navController.navigate(Screen.PaymentScreen)

                    }
                )
            }
        }
    }
}