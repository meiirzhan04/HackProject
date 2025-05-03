package com.example.sxodimsduu.mainScreen

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sxodimsduu.data.Club

@Preview
@Composable
fun GenreSelectionScreen() {
    // State for selected genres
    val clubs = remember {
        mutableStateListOf(
            Club("Action"),
            Club("Horror"),
            Club("Fantasy"),
            Club("Anime"),
            Club("Romance"),
            Club("Sci-Fi"),
            Club("Comedy"),
            Club("Adventures")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        // Genre title
        Text(
            text = "Clubs",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Genre grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(clubs.size) { index ->
                GenreItem(
                    club = clubs[index],
                    onSelected = {
                        clubs[index] = clubs[index].copy(isSelected = !clubs[index].isSelected)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Footer text
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Jovien.",
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                text = "100TCAST",
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun GenreItem(club: Club, onSelected: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                color = if (club.isSelected) Color.Gray else Color.DarkGray,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onSelected() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = club.name,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}