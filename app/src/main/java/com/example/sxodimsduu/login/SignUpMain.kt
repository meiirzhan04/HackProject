package com.example.sxodimsduu.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sxodimsduu.R
import com.example.sxodimsduu.data.Screen

@Composable
fun SignUp(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF_1F1D2B))
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(160.dp))
        Icon(painter = painterResource(id = R.drawable.ic_logo), contentDescription = null)
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "SxodimSDU",
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Enter your registered \n" + "Phone Number to Sign Up",
            fontSize = 14.sp,
            color = Color(0xFF_92929D),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            letterSpacing = 0.5.sp,
        )
        Spacer(modifier = Modifier.height(64.dp))
        CustomButton(
            text = "Sign Up",
            onClick = {
                navController.navigate(Screen.SignUpScreen)
            }
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row {
           Text(
               text = "I Already have an account? ",
               color = Color(0xFF_92929D),
               fontWeight = FontWeight.Medium
           )
            Text(
                text = "Login",
                color = Color(0xFF_12CDD9),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable(
                    onClick = {
                        navController.navigate(Screen.LoginScreen)
                    }
                )
           )
        }
    }
}