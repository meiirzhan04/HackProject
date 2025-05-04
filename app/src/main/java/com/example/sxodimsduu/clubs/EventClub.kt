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
fun EventScreen(navController: NavHostController) {
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
                    painter = painterResource(id = R.drawable.evemt_awards),
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
                    text = "SDU Awards",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "02.05.2025  |  18:30  |  Red Hall",
                    color = Color(0xFF_9CA3AF),
                )
                HorizontalDivider(
                    color = Color(0xFF_1C2431),
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 24.dp)
                )
                Text(
                    text = "Hello, SDUdents!\n" +
                            "\n" +
                            "The school year is coming to an end, which means that it's time to celebrate the highlights and achievements!\uD83D\uDCA5\n" +
                            "\n" +
                            "We are pleased to announce that the Event Club is organizing a grand award ceremony where each of you can become a part of history!\uD83D\uDC99\n" +
                            "\n" +
                            "✨«SDU AWARDS 2025»✨\n" +
                            "We have prepared 14 cool and interesting nomination categories in which you can prove yourself.:\n" +
                            "- Freshman of the Year\n" +
                            "- Student of the Year\n" +
                            "- Organisation of the Year\n" +
                            "- Breakthrough of the Year\n" +
                            "- Project of the Year\n" +
                            "- Collaboration of the Year\n" +
                            "- Event of the Year\n" +
                            "- Activist of the Year\n" +
                            "- Sportsman of the Year\n" +
                            "- Popular teacher of the Year\n" +
                            "- International student of the Year\n" +
                            "- Alumni of the Year\n" +
                            "- Performance of the Year\n" +
                            "- Popular staff of the Year\n" +
                            "\n" +
                            ", How to participate?\n" +
                            "Applications are already open and will last until 03.04 12:00. Fill out the form using the link in your profile!\n" +
                            "\n" +
                            "Who decides the fate of the winners?\n" +
                            "The best will be determined by an independent commission and you! Your voice plays a key role – let's choose the best together!\n" +
                            "\n" +
                            "Do you want your favorite to win? The more times your name appears in the applications, the higher your chances that you will be chosen as the nominee! Support the worthy ones – let the best take their well-deserved awards! \uD83C\uDFC6✨\n" +
                            "\n" +
                            "Don't miss the chance to be a part of this unforgettable event! Come support your friends and enjoy the festive atmosphere! \uD83C\uDF89",
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
                        text = "Event Club",
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