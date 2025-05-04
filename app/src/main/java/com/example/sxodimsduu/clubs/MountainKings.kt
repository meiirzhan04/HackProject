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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sxodimsduu.R
import com.example.sxodimsduu.login.CustomButton

@Preview
@Composable
fun MountainScreen(
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.almaty_lake_mountain),
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
                    text = "Big Almaty Lake",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "04.05.2025  |  11:30  |  Red Canteen",
                    color = Color(0xFF_9CA3AF),
                )
                HorizontalDivider(
                    color = Color(0xFF_1C2431),
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 24.dp)
                )
                Text(
                    text = "ARE YOU READY FOR THE FINAL HIKE OF THE SEMESTER!? \uD83E\uDD2F\uD83D\uDE31\n" +
                            "\n" +
                            "We’re planning a trip to BIG ALMATY LAKE at the end of this week! \uD83E\uDD73\uD83E\uDD29\n" +
                            "\n" +
                            "Make sure to get your ticket, as the number of tickets is limited! \uD83E\uDD2B\n" +
                            "\n" +
                            "⏰WHEN? ⏰\n" +
                            "4th of May\n" +
                            "\n" +
                            "\uD83C\uDF9FTICKET PRICE \uD83C\uDF9F\n" +
                            "3 000 KZT\n" +
                            "\n" +
                            "\uD83E\uDDD7\uD83C\uDFFB\u200D♂\uFE0FDIFFICULTY LEVEL \uD83E\uDDD7\uD83C\uDFFB\u200D♂\uFE0F\n" +
                            "Difficult (4 / 5)\n" +
                            "\n" +
                            "What’s included:\n" +
                            "\uD83D\uDEE3Eco-post fee\n" +
                            "\uD83D\uDE8DTransportation\n" +
                            "\uD83C\uDFB2Fun games\n" +
                            "\uD83D\uDCF8Photo & video coverage\n" +
                            "\n" +
                            "Ticket sales start today at 11:30 near RED CANTEEN \uD83C\uDFAF\n" +
                            "\n" +
                            "We can’t wait to see you all there!\n" +
                            "\n" +
                            "With love, MK\uD83C\uDFD4\uD83D\uDC99",
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
                        text = "Mountain Kings",
                        color = Color(0xFF_9CA3AF)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                CustomButton(
                    "Get Ticket",
                    Color(0xFF_FF8700),
                    onClick = {

                    }
                )
            }
        }
    }
}