package com.example.sxodimsduu

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.sxodimsduu.data.Screen
import com.example.sxodimsduu.navigation.NavGraph
import com.example.sxodimsduu.viewmodel.OnboardingPreferences
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    companion object {
        const val CHANNEL_ID = "simple_channel"
    }
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

@SuppressLint("MissingPermission", "NotificationPermission")
@Composable
fun SimpleNotificationScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            val notif = NotificationCompat.Builder(context, MainActivity.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_profile) // добавьте свой икон в res/drawable
                .setContentTitle("Простое уведомление")
                .setContentText("Это локальное уведомление сразу по нажатию")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .build()

            val notificationManager = NotificationManagerCompat.from(context)
            notificationManager.notify(1, notif)
        }) {
            Text("Показать уведомление")
        }
    }
}