package com.example.sxodimsduu.data

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    object SplashScreen : Screen
    @Serializable
    object OnboardingScreen : Screen
    @Serializable
    object LoginScreen : Screen
    @Serializable
    object SignUpScreen : Screen
    @Serializable
    object SearchScreen : Screen
    @Serializable
    object SignUpMain : Screen
    @Serializable
    object MainScreen : Screen
    @Serializable
    object ProfileScreen : Screen
    @Serializable
    object FavoriteScreen : Screen
    @Serializable
    object HomeScreen : Screen
}