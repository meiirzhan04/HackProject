@file:Suppress("DEPRECATION")

package com.example.sxodimsduu.login

import android.R.attr.tag
import androidx.compose.foundation.Image
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sxodimsduu.R
import java.nio.file.WatchEvent
import android.util.Log
import android.widget.Toast
import com.example.sxodimsduu.data.Screen

@Composable
fun SignUpScreen(
    navController: NavController
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isClicked by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }  // Для отображения состояния загрузки

    val onSignUpClicked = let@{
        Log.d("SignUp", "Sign Up button clicked")

        // Проверяем, чтобы данные были заполнены
        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            // Валидация email
            if (!email.endsWith("@sdu.edu.kz")) {
                println("Invalid email format. Please use your @sdu.edu.kz email.")
                return@let
            }

            // Валидация пароля: минимум 8 символов, хотя бы одна цифра, одна заглавная буква, один специальный символ
            val passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}\$"
            if (!password.matches(passwordPattern.toRegex())) {
                println("Password must be at least 8 characters long, include at least one uppercase letter, one digit, and one special character.")
                return@let
            }

            isLoading = true

            val newUser = User(
                sdu_email = email,
                password = password,
                name = name
            )

            // Отправляем запрос на сервер с использованием Retrofit
            RetrofitInstance.api.signUp(newUser).enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    isLoading = false
                    if (response.isSuccessful) {
                        Log.d("SignUp", "Data validated, sending request...")
                        // Успешная регистрация
                        println("Successful login!") // Переводим на экран логина
                    } else {
                        // Обработка ошибок, например, неверный email или пароль
                        println("Error: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    isLoading = false
                    // Ошибка соединения или другие проблемы
                    println("Failure: ${t.message}")
                }
            })
        } else {
            Log.d("SignUp", "Please fill in all fields")
            // Показать сообщение о том, что поля должны быть заполнены
            println("Please fill in all fields")
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF_1F1D2B))
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Sign Up",
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
            letterSpacing = 0.5.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 64.dp),
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Let’s get started",
            fontSize = 24.sp,
            fontWeight = FontWeight.W600,
            letterSpacing = 0.5.sp,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "The latest movies and series are here",
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            letterSpacing = 0.5.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(72.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
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
                    text = "Full Name",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF_EBEBEF)
                )
            },
            shape = RoundedCornerShape(24.dp),
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
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
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
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
                    text = "Password",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF_EBEBEF)
                )
            },
            visualTransformation = if (!isClicked) VisualTransformation.None else PasswordVisualTransformation(),
            shape = RoundedCornerShape(24.dp),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = if (isClicked) R.drawable.ic_eye_open else R.drawable.ic_eye_close),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable(
                            onClick = {
                                isClicked = !isClicked
                            }
                        ),
                    tint = Color(0xFF_92929D)
                )
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
        TermsOfServiceAgreementRow(
            modifier = Modifier
                .fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(40.dp))
        CustomButton(
            text = "Sign Up",
            onClick = {
                navController.navigate(Screen.HomeScreen)
                onSignUpClicked
            },
        )
    }
}


@Composable
fun TermsOfServiceAgreementRow(
    modifier: Modifier = Modifier,
    onTermsClicked: () -> Unit = {},
    onPrivacyClicked: () -> Unit = {}
) {
    var isCheck = remember { mutableStateOf(false) }
    val orangeColor = Color(0xFF_12CDD9)
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color(0xFF_92929D),
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
            )
        ) {
            append("I Agree with ")
        }
        pushStringAnnotation(tag = "TOS", annotation = "TermsOfService")
        withStyle(
            style = SpanStyle(
                color = orangeColor,
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,

            )
        ) {
            append("Terms and Services")
        }
        pushStringAnnotation(tag = "TOS", annotation = "Terms and Services")
        withStyle(
            style = SpanStyle(
                color = Color(0xFF_92929D),
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
            )
        ) {
            append(" \nand ")
        }
        pushStringAnnotation(tag = "Privacy", annotation = "PrivacyPolicy")
        withStyle(
            style = SpanStyle(
                color = orangeColor,
                fontWeight = FontWeight.SemiBold,
            )
        ) {
            append("Privacy Policy")
        }
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Checkbox(
            checked = isCheck.value,
            onCheckedChange = { isCheck.value = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF_92929D),
                uncheckedColor = Color(0xFF_92929D)
            ),
        )
        Spacer(modifier = Modifier.width(8.dp))
        @Suppress("DEPRECATION")
        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(
                    start = offset,
                    end = offset
                )
                    .firstOrNull()?.let { annotation ->
                        when (annotation.tag) {
                            "TOS" -> onTermsClicked()
                            "Privacy" -> onPrivacyClicked()
                        }
                    }
            }
        )
    }

}