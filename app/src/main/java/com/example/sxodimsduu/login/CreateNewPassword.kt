package com.example.sxodimsduu.login

import android.R.attr.navigationIcon
import android.R.attr.password
import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sxodimsduu.R
import com.example.sxodimsduu.R.drawable
import com.example.sxodimsduu.R.drawable.*

@Preview
@ExperimentalMaterial3Api
@Composable
fun CreateNewPassword() {
    var isClicked1 by remember { mutableStateOf(false) }
    var isClicked2 by remember { mutableStateOf(false) }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1F1D2B)),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Login",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF1F1D2B)
                ),
                navigationIcon = {
                    Image(
                        painter = painterResource(id = ic_back),
                        contentDescription = null,
                        modifier = Modifier.clickable(
                            onClick = {}
                        )
                    )
                },
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF1F1D2B))
                .padding(horizontal = 24.dp)
                .padding(paddingValues = contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Create new Password",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Enter your new password",
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(64.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = newPassword,
                onValueChange = { newPassword = it },
                label = { Text(text = "New Password") },
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFF_252836),
                    focusedBorderColor = Color(0xFF_252836),
                    focusedTextColor = Color(0xFF_EBEBEF),
                    focusedLabelColor = Color(0xFF_EBEBEF),
                    unfocusedTextColor = Color(0xFF_92929D)
                ),
                visualTransformation = if (!isClicked1) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = if(isClicked1) ic_eye_off else ic_eye_open),
                        contentDescription = null,
                        modifier = Modifier.clickable(
                            onClick = {
                                isClicked1 = !isClicked1
                            }
                        ),
                        tint = Color(0xFF_92929D)
                    )
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text(text = "Confirm Password") },
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFF_252836),
                    focusedBorderColor = Color(0xFF_252836),
                    focusedTextColor = Color(0xFF_EBEBEF),
                    focusedLabelColor = Color(0xFF_EBEBEF),
                    unfocusedTextColor = Color(0xFF_92929D)
                ),
                visualTransformation = if (!isClicked2) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = if(isClicked2) ic_eye_off else ic_eye_open),
                        contentDescription = null,
                        modifier = Modifier.clickable(
                            onClick = {
                                isClicked2 = !isClicked2
                            }
                        ),
                        tint = Color(0xFF_92929D)
                    )
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Forgot Password?",
                fontSize = 12.sp,
                color = Color(0xFF12CDD9),
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable(
                        onClick = {}
                    )
            )
            Spacer(modifier = Modifier.height(40.dp))
            CustomButton(text = "Login")
        }
    }
}
