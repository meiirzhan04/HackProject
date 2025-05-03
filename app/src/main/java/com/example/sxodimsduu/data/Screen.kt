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
    object HomeScreen : Screen
    @Serializable
    object SignUpMain : Screen
}