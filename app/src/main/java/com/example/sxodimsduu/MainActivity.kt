package com.example.sxodimsduu

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.sxodimsduu.data.Screen
import com.example.sxodimsduu.login.SignUpScreen
import com.example.sxodimsduu.navigation.NavGraph
import com.example.sxodimsduu.onboarding.OnboardingScreen
import com.example.sxodimsduu.ui.theme.SxodimSduuTheme
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