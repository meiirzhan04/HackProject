package com.example.sxodimsduu.login

import android.R.attr.password
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sxodimsduu.R

@Composable
fun ResetPasswordScreen(
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF_1F1D2B))
            .padding(horizontal = 24.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(104.dp))
        Text(
            text = "Reset Password",
            fontSize = 24.sp,
            fontWeight = FontWeight.W600,
            letterSpacing = 0.5.sp,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Recover your account password",
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            letterSpacing = 0.5.sp,
            color = Color(0xFF_92929D),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(72.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = Color(0xFF_92929D)
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color(0xFF_252836),
            ),
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Email Address",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF_EBEBEF)
                )
            },
            shape = RoundedCornerShape(24.dp),
        )
        Spacer(modifier = Modifier.height(40.dp))
        CustomButton(
            text = "Next",
            onClick = {}
        )
    }
}

