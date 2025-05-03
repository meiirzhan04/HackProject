package com.example.sxodimsduu.mainScreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sxodimsduu.data.Screen
import com.example.sxodimsduu.mainscreens.FavoriteScreen
import com.example.sxodimsduu.mainscreens.ProfileScreen
import com.example.sxodimsduu.mainscreens.SearchScreen
import com.example.sxodimsduu.navigation.BottomNavigationBar


@Composable
fun HomeScreen(navController: NavHostController) {
    val navController = rememberNavController()
    val isChecked = remember { mutableStateOf(false) }
    Scaffold(
        bottomBar = {
            if (isChecked.value) {
                BottomNavigationBar(navController)
            } else {
                null
            }
        }
    ) {
        it
        NavHost(
            navController = navController,
            startDestination = Screen.MainScreen,
        ) {
            composable<Screen.MainScreen> {
                MainScreen(navController)
                isChecked.value = true
            }
            composable<Screen.FavoriteScreen> {
                FavoriteScreen(navController)
                isChecked.value = true
            }
            composable<Screen.SearchScreen> {
                SearchScreen(navController)
                isChecked.value = true
            }
            composable<Screen.ProfileScreen> {
                ProfileScreen(navController)
                isChecked.value = true
            }
            composable<Screen.HomeScreen> {
                HomeScreen(navController)
                isChecked.value = true
            }
        }
    }
}