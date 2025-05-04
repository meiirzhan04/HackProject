package com.example.sxodimsduu.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
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
import com.example.sxodimsduu.login.LoginScreen
import com.example.sxodimsduu.login.SignUp
import com.example.sxodimsduu.login.SignUpScreen
import com.example.sxodimsduu.mainScreen.PaymentScreen
import com.example.sxodimsduu.mainScreen.TicketScreen
import com.example.sxodimsduu.mainscreens.AboutUsScreen
import com.example.sxodimsduu.mainscreens.EditProfile
import com.example.sxodimsduu.mainscreens.HelpScreen
import com.example.sxodimsduu.mainscreens.LegalAndPoliciesScreen
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
        composable<Screen.ArtClub> {
            ArtScreen(
                navController = navController,
            )
        }
        composable<Screen.DombyraClub> {
            DombyraScreen(
                navController = navController,
            )
        }
        composable<Screen.EventClub> {
            EventScreen(
                navController = navController,
            )
        }
        composable<Screen.MusicClub> {
            MusicScreen(
                navController = navController,
            )
        }
        composable<Screen.MountainKings> {
            MountainScreen(
                navController = navController,
            )
        }
        composable<Screen.OrleanClub> {
            OrleanScreen(
                navController = navController,
            )
        }
        composable<Screen.WeClub> {
            WeScreen(
                navController = navController,
            )
        }
        composable<Screen.ZhasaClub> {
            ZhasaScreen(
                navController = navController,
            )
        }
        composable<Screen.PaymentScreen> {
            PaymentScreen(
                navController = navController,
            )
        }
        composable<Screen.EditProfile> {
            EditProfile(
                navController = navController,
            )
        }
        composable<Screen.TicketScreen> {
            TicketScreen(
                navController = navController,
            )
        }
        composable<Screen.AboutUsScreen> {
            AboutUsScreen(
                navController = navController,
            )
        }
        composable<Screen.HelpAndFeedback> {
            HelpScreen(
                navController = navController,
            )
        }
        composable<Screen.LegalAndPolicies> {
            LegalAndPoliciesScreen(
                navController = navController,
            )
        }
    }
}
