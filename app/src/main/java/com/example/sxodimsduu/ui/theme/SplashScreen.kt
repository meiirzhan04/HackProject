package com.example.sxodimsduu.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sxodimsduu.R
import com.example.sxodimsduu.data.Screen
import com.example.sxodimsduu.viewmodel.OnboardingPreferences
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavController, onboardingPreferences: OnboardingPreferences) {
    val coroutineScope = rememberCoroutineScope()
    var isOnboardingCompleted by remember { mutableStateOf<Boolean?>(null) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            delay(2000)
            isOnboardingCompleted = onboardingPreferences.isOnboardingCompleted.first()
            navController.navigate(if (isOnboardingCompleted == true) Screen.SignUpMain else Screen.OnboardingScreen) {
                popUpTo(Screen.SplashScreen) { inclusive = true }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF_1F1D2B)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.sxodim),
            contentDescription = null,
            modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(16.dp)),
        )

    }

}