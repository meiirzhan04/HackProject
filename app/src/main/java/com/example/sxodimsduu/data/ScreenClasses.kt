package com.example.sxodimsduu.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sxodimsduu.R

data class ScreenClasses(
    val image: Int,
    val title: String,
    val description: String,
)

val listOfScreenClasses = listOf(
    ScreenClasses(
        image = R.drawable.we_club,
        title = "Screen 1",
        description = "This is screen 1"
    ),
    ScreenClasses(
        image = R.drawable.we_club,
        title = "Screen 2",
        description = "This is screen 2"
    ),
    ScreenClasses(
        image = R.drawable.we_club,
        title = "Screen 3",
        description = "This is screen 3"
    )
)


@Composable
fun ScreenBox(item: ScreenClasses) {
    Card(
        modifier = Modifier.height(200.dp).width(135.dp),
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFF_252836)).padding(15.dp)
        ) {
            Text(
                text = item.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                color = Color.White
            )
            Text(
                text = item.description,
                fontSize = 10.sp,
                color = Color(0xFF_92929D)
            )
        }
    }
}