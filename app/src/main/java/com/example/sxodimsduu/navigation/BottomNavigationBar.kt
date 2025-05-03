package com.example.sxodimsduu.navigation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sxodimsduu.R
import com.example.sxodimsduu.data.Screen
import com.example.sxodimsduu.mainscreens.ProfileScreen
import com.example.sxodimsduu.mainscreens.SearchScreen

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        containerColor = Color(0xFF_1F1D2B),
    ) {
        val items = listOf(
            NavigationItem(Screen.MainScreen, R.drawable.ic_home),
            NavigationItem(Screen.SearchScreen, R.drawable.ic_search),
            NavigationItem(Screen.FavoriteScreen, R.drawable.ic_favourite),
            NavigationItem(Screen.ProfileScreen, R.drawable.ic_profile),
        )
        var isSelected by remember { mutableIntStateOf(0) }
        items.forEachIndexed { index, item ->
            val selectedColor = Color(0xFF7E2DFC)
            val scale by animateFloatAsState(
                targetValue = if (isSelected == index) 1.1f else 1f,
                animationSpec = tween(durationMillis = 400)
            )
            NavigationBarItem(
                selected = isSelected == index,
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = "",
                        modifier = Modifier.graphicsLayer(scaleX = scale, scaleY = scale),
                        tint = if (isSelected == index) selectedColor else Color.Gray
                    )
                },
                onClick = {
                    navController.navigate(item.screen) {
                        popUpTo(Screen.MainScreen) { inclusive = false }
                    }
                    isSelected = index
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = selectedColor,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}
