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
    @Serializable
    object ArtClub : Screen
    @Serializable
    object EventClub : Screen
    @Serializable
    object MusicClub : Screen
    @Serializable
    object MountainKings : Screen
    @Serializable
    object OrleanClub : Screen
    @Serializable
    object WeClub : Screen
    @Serializable
    object ZhasaClub : Screen
    @Serializable
    object DombyraClub : Screen
    @Serializable
    object PaymentScreen : Screen
    @Serializable
    object EditProfile : Screen
    @Serializable
    object TicketScreen : Screen
}