package com.example.sxodimsduu.mainScreen

import ProfileScreen
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sxodimsduu.clubs.ArtScreen
import com.example.sxodimsduu.clubs.DombyraScreen
import com.example.sxodimsduu.clubs.EventScreen
import com.example.sxodimsduu.clubs.MountainScreen
import com.example.sxodimsduu.clubs.MusicScreen
import com.example.sxodimsduu.clubs.OrleanScreen
import com.example.sxodimsduu.clubs.WeScreen
import com.example.sxodimsduu.clubs.ZhasaScreen
import com.example.sxodimsduu.data.Screen
import com.example.sxodimsduu.mainscreens.FavoriteScreen
import com.example.sxodimsduu.mainscreens.SearchScreen
import com.example.sxodimsduu.navigation.BottomNavigationBar


@OptIn(ExperimentalMaterial3Api::class)
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
                ProfileScreen()
                isChecked.value = true
            }
            composable<Screen.HomeScreen> {
                HomeScreen(navController)
                isChecked.value = true
            }
            composable<Screen.ArtClub> {
                ArtScreen(navController)
                isChecked.value = false
            }
            composable<Screen.DombyraClub> {
                DombyraScreen(navController)
                isChecked.value = false
            }
            composable<Screen.EventClub> {
                EventScreen(navController)
                isChecked.value = false
            }
            composable<Screen.MusicClub> {
                MusicScreen(navController)
                isChecked.value = false
            }
            composable<Screen.MountainKings> {
                MountainScreen(navController)
                isChecked.value = false
            }
            composable<Screen.OrleanClub> {
                OrleanScreen(navController)
                isChecked.value = false
            }
            composable<Screen.WeClub> {
                WeScreen(navController)
                isChecked.value = false
            }
            composable<Screen.ZhasaClub> {
                ZhasaScreen(navController)
                isChecked.value = false
            }
            composable<Screen.PaymentScreen> {
                PaymentScreen(navController)
                isChecked.value = false
            }
        }
    }
}