package com.example.sxodimsduu.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sxodimsduu.data.Screen
import com.example.sxodimsduu.login.LoginScreen
import com.example.sxodimsduu.login.SignUp
import com.example.sxodimsduu.login.SignUpScreen
import com.example.sxodimsduu.mainScreen.MainScreen
import com.example.sxodimsduu.mainscreens.SearchScreen
import com.example.sxodimsduu.onboarding.OnboardingScreen
import com.example.sxodimsduu.ui.theme.SplashScreen
import com.example.sxodimsduu.viewmodel.OnboardingPreferences

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(
    startDestination: Screen.SplashScreen,
    onboardingPreferences: OnboardingPreferences,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Screen.SplashScreen> {
            SplashScreen(
                navController = navController,
                onboardingPreferences = onboardingPreferences
            )
        }
        composable<Screen.OnboardingScreen> {
            OnboardingScreen(
                navController = navController,
            )
        }
        composable<Screen.LoginScreen> {
            LoginScreen(
                navController = navController,
            )
        }
        addMainScreens(
            navController
        )

        composable<Screen.SignUpScreen> {
            SignUpScreen(
                navController = navController,
            )
        }
        composable<Screen.SignUpMain> {
            SignUp(
                navController = navController,
            )
        }

    }
}