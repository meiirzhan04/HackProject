package com.example.sxodimsduu.mainScreen

import android.R.attr.onClick
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sxodimsduu.R
import com.example.sxodimsduu.data.Club
import kotlin.math.log

@Preview
@Composable
fun ClubSelectionScreen() {
    // State with background images
    val clubs = remember {
        mutableStateListOf(
            Club(R.drawable.we_club),
            Club(R.drawable.zhasa_club),
            Club(R.drawable.event_club),
            Club(R.drawable.music_club),
            Club(R.drawable.art_club),
            Club(R.drawable.mountain_kings),
            Club(R.drawable.dombyra_club),
            Club(R.drawable.orlean_club)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF_1F1D2B))
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        // Title
        Text(
            text = "Clubs",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Clubs grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(clubs.size) { index ->
                ClubItemWithBackground(
                    club = clubs[index],
                    onClick = {

                    }
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ClubItemWithBackground(club: Club, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable (onClick = onClick)
    ) {
        // Background image
        Image(
            painter = painterResource(id = club.image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Dark overlay with different opacity when selected
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    if (club.isSelected)
                        Color.Black.copy(alpha = 0.5f)
                    else
                        Color.Black.copy(alpha = 0.3f)
                )
        )
    }
}