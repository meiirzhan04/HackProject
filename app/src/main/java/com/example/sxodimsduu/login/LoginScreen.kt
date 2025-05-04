package com.example.sxodimsduu.login


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sxodimsduu.R.drawable.ic_back
import com.example.sxodimsduu.R.drawable.ic_eye_close
import com.example.sxodimsduu.R.drawable.ic_eye_open
import com.example.sxodimsduu.data.Screen
import com.example.sxodimsduu.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isClicked by remember { mutableStateOf(false) }

    val onLoginClicked: () -> Unit = {
        Log.d("Login", "Login button clicked")
        if (email.isNotEmpty() && password.isNotEmpty()) {
            val credentials = LoginRequest(username = email, password = password)
            RetrofitInstance.api.login(credentials)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        Log.d("Login", "Token: ${response.body()?.token}")
                        navController.navigate("main_screen")
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Log.e("Login", "Error", t)
                    }
                })
        } else {
            Log.d("Login", "Please fill in all fields")
        }
        // Явно возвращаем Unit, чтобы лямбда была ()->Unit
        Unit
    }

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
                            onClick = {

                            }
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
                text = "Hi",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Welcome back! Please enter \n your details",
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(64.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { email = it },
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF_252836),
                    unfocusedBorderColor = Color(0xFF_252836),
                    focusedTextColor = Color(0xFF_92929D),
                    unfocusedTextColor = Color(0xFF_92929D),
                    focusedLabelColor = Color(0xFF_EBEBEF)
                ),
                placeholder = {
                    Text(
                        text = "Email Address",
                        color = Color(0xFF_92929D)
                    )
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text(
                        text = "Password",
                        color = Color(0xFF_92929D)
                    )
                },
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF_252836),
                    unfocusedBorderColor = Color(0xFF_252836),
                    focusedTextColor = Color(0xFF_92929D),
                    unfocusedTextColor = Color(0xFF_92929D),
                    focusedLabelColor = Color(0xFF_EBEBEF)
                ),
                visualTransformation = if (!isClicked) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = if (isClicked) ic_eye_close else ic_eye_open),
                        contentDescription = null,
                        modifier = Modifier.clickable(
                            onClick = {
                                isClicked = !isClicked
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
                        onClick = {

                        }
                    )
            )
            Spacer(modifier = Modifier.height(40.dp))
            CustomButton(
                text = "Login",
                onClick = {
                    onLoginClicked()
                    navController.navigate(Screen.HomeScreen)
                }
            )

        }
    }


}