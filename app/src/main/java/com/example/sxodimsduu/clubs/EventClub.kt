package com.example.sxodimsduu.clubs

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
fun EventScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.evemt_awards) ,
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
                    text = "SDU Awards" ,
                    color = Color.White ,
                    fontSize = 24.sp ,
                    fontWeight = FontWeight.Bold ,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "02.05.2025  |  18:30  |  Red Hall" ,
                    color = Color(0xFF_9CA3AF) ,
                )
                HorizontalDivider(
                    color = Color(0xFF_1C2431) ,
                    thickness = 1.dp ,
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
                            "Don't miss the chance to be a part of this unforgettable event! Come support your friends and enjoy the festive atmosphere! \uD83C\uDF89" ,
                    color = Color(0xFF_E5E7EB) ,
                    fontSize = 14.sp ,
                    lineHeight = 22.sp ,
                    letterSpacing = 0.5.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Text(
                        text = "Organizers:" ,
                        color = Color(0xFF_4B5563)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Event Club" ,
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