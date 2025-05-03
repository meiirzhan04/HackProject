package com.example.sxodimsduu.clubs

import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sxodimsduu.R
import com.example.sxodimsduu.login.CustomButton

@Preview
@Composable
fun DombyraScreen(
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ne_prosto_dombyra) ,
                    contentDescription = null ,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft ,
                    contentDescription = null ,
                    tint = Color.White ,
                    modifier = Modifier
                        .padding(24.dp)
                        .padding(vertical = 24.dp)
                        .size(32.dp)
                        .clickable(
                            onClick = {

                            } ,
                            indication = ripple(bounded = true) ,
                            interactionSource = null
                        )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                        .align(Alignment.BottomStart) ,
                    verticalAlignment = Alignment.CenterVertically ,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF_111827))
                    .clip(shape = RoundedCornerShape(topStart = 32.dp , topEnd = 32.dp))
                    .padding(24.dp)
            ) {
                Text(
                    text = "Ne Prosto Dombyra" ,
                    color = Color.White ,
                    fontSize = 24.sp ,
                    fontWeight = FontWeight.Bold ,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "22.04.2025  |  17:30  |  Red Hall" ,
                    color = Color(0xFF_9CA3AF) ,
                )
                HorizontalDivider(
                    color = Color(0xFF_1C2431) ,
                    thickness = 1.dp ,
                    modifier = Modifier.padding(vertical = 24.dp)
                )
                Text(
                    text = "DOMBYRA CLUB x WE\n" +
                            "NE PROSTO DOMBYRA\n" +
                            "\n" +
                            "Dombyra is more than tradition.\n" +
                            "It’s style. It’s experimentation. It’s a new sound.\n" +
                            "We’re bringing you an atmosphere you’ve never felt before.\n" +
                            "When küy meets modern rhythms — magic happens.\n" +
                            "\n" +
                            "APRIL 22 | 5:30 PM | RED HALL\n" +
                            "✨ Come. Feel it. Be amazed. ✨" ,
                    color = Color(0xFF_E5E7EB) ,
                    fontSize = 14.sp ,
                    lineHeight = 22.sp ,
                    letterSpacing = 0.5.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row() {
                    Text(
                        text = "Organizers:" ,
                        color = Color(0xFF_4B5563)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Dombyra club" ,
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