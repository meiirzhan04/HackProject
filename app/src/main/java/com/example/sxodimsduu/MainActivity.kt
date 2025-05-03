package com.example.sxodimsduu

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import com.example.sxodimsduu.data.Screen
import com.example.sxodimsduu.navigation.NavGraph
import com.example.sxodimsduu.viewmodel.OnboardingPreferences
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    private lateinit var onboardingPreferences: OnboardingPreferences
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onboardingPreferences = OnboardingPreferences(this)
        lifecycleScope.launch {
            setContent {
                NavGraph(
                    startDestination = Screen.SplashScreen,
                    onboardingPreferences,
                )
            }
        }
    }
}

