package com.example.sxodimsduu.mainScreen

import android.os.CountDownTimer
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.ripple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sxodimsduu.data.Screen
import com.example.sxodimsduu.data.ScreenBox
import com.example.sxodimsduu.data.listOfScreenClasses

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF_1F1D2B))
    ) {
        item {
            Spacer(modifier = Modifier.height(50.dp))
            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                },
                colors = androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF_9753F0),
                    unfocusedBorderColor = Color(0xFF_1C2431),
                    textColor = Color(0xFF_92929D),
                    cursorColor = Color(0xFF_9753F0),
                    backgroundColor = Color(0xFF_252836),
                ),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    textAlign = TextAlign.Start,
                ),
                shape = RoundedCornerShape(24.dp),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                placeholder = {
                    Text(
                        text = "Search a title..",
                        color = Color(0xFF_9CA3AF),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W600,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                },
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Categories",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            CategoryTabs()
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Most popular",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Text(
                    text = "See All",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF_12CDD9),
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .clickable(
                            onClick = {},
                            indication = ripple(bounded = true),
                            interactionSource = null
                        ),
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(
                modifier = Modifier
            ) {
                items(listOfScreenClasses) { item ->
                    Spacer(modifier = Modifier.width(24.dp))
                    ScreenBox(item = item, onClick = {
                        navController.navigate(Screen.WeClub)
                    })
                }
            }
        }
    }

}

@Composable
fun CategoryTabs() {
    val categories = listOf("All", "After 1-3 day", "After 4-7 day", "After 8-14 day")
    val selectedCategory = remember { mutableStateOf("All") }

    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 15.dp)
    ) {
        item {
            categories.forEach { category ->
                Button(
                    onClick = { selectedCategory.value = category },
                    colors = if (selectedCategory.value == category) {
                        ButtonDefaults.buttonColors(containerColor = Color.Black)
                    } else {
                        ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    },
                ) {
                    Text(
                        text = category,
                        color = if (selectedCategory.value == category) Color.Cyan else Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}

@Composable
fun CountdownTimer() {
    val timeInMillis: MutableState<Long> =
        remember { mutableStateOf(39 * 60 * 1000 + 27 * 1000L) }

    val countDownTimer = object : CountDownTimer(timeInMillis.value, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            timeInMillis.value = millisUntilFinished
        }

        override fun onFinish() {}
    }
    countDownTimer.start()

    val hours = (timeInMillis.value / 1000) / 3600
    val minutes = ((timeInMillis.value / 1000) % 3600) / 60
    val seconds = (timeInMillis.value / 1000) % 60

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Left",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = String.format("%02d : %02d : %02d", hours, minutes, seconds),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}
