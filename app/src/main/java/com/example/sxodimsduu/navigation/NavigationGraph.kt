package com.example.sxodimsduu.navigation

import ProfileScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.sxodimsduu.data.Screen
import com.example.sxodimsduu.mainScreen.HomeScreen
import com.example.sxodimsduu.mainScreen.PaymentScreen
import com.example.sxodimsduu.mainscreens.FavoriteScreen
import com.example.sxodimsduu.mainscreens.SearchScreen

fun NavGraphBuilder.addMainScreens(navController: NavHostController) {
    composable<Screen.HomeScreen> {
        HomeScreen(
            navController,
        )
    }
    composable<Screen.ProfileScreen> {
        ProfileScreen()
    }
    composable<Screen.SearchScreen> {
        SearchScreen(navController)
    }
    composable<Screen.FavoriteScreen> {
        FavoriteScreen(navController)
    }
}
