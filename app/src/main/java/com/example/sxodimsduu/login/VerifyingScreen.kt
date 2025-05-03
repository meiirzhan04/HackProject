@file:Suppress("DEPRECATION")

package com.example.sxodimsduu.login

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextButton
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sxodimsduu.R
import com.example.sxodimsduu.data.Screen
import kotlinx.coroutines.delay

@Composable
fun VerificationScreen(navController: NavController) {
    var otp by remember { mutableStateOf(List(4) { "" }) }
    val onOtpClicked: () -> Unit = {}
    val focusManager = LocalFocusManager.current
    val orangeColor = Color(0xFF_12CDD9)
    val annotatedTextOtp = buildAnnotatedString {
        pushStringAnnotation(tag = "Resend", annotation = "Resend")
        withStyle(
            style = SpanStyle(
                color = Color(0xFF_92929D),
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.5.sp
            )
        ) {
            append("Didn’t receive code? ")
        }
        pushStringAnnotation(tag = "Resend", annotation = "Resend")
        withStyle(
            style = SpanStyle(
                color = orangeColor,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.5.sp
            )
        ) {
            append("Resend")
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF_1F1D2B))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(104.dp))
        Text(
            text = "Verifying your account",
            fontSize = 24.sp,
            fontWeight = FontWeight.W600,
            letterSpacing = 0.5.sp,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "We have just sent you 4 digit code via your email example@gmail.com",
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            letterSpacing = 0.5.sp,
            color = Color(0xFF_92929D),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(4) { index ->
                androidx.compose.material3.OutlinedTextField(
                    value = otp[index],
                    onValueChange = { newValue ->
                        if (newValue.length <= 1 && newValue.all {
                                it.isDigit()
                            }
                        ) {
                            otp = otp
                                .toMutableList()
                                .apply {
                                    this[index] = newValue
                                }
                        }
                        if (newValue.isNotEmpty() && index < 3 && newValue.all {
                                it.isDigit()
                            }) {
                            focusManager.moveFocus(FocusDirection.Right)
                        } else if (newValue.isEmpty() && index > 0 && newValue.all {
                                it.isDigit()
                            }) {
                            focusManager.moveFocus(FocusDirection.Left)
                        }
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    maxLines = 1,
                    modifier = Modifier
                        .size(75.dp),
                    textStyle = TextStyle(
                        fontSize = 32.sp,
                        lineHeight = 40.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF_EAEAEA)
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF_12CDD9),
                        unfocusedBorderColor = Color(0xFF_EAEAEA)
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(64.dp))
        CustomButton(
            text = "Continue",
            onClick = {
                navController.navigate(Screen.SignUpMain)
            }
        )

        Spacer(modifier = Modifier.height(42.dp))
        ClickableText(
            text = annotatedTextOtp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = { offset ->
                annotatedTextOtp.getStringAnnotations(
                    start = offset,
                    end = offset
                )
                    .firstOrNull()?.let { annotation ->
                        when (annotation.tag) {
                            "Resend" -> onOtpClicked()
                        }
                    }
            }
        )
    }
}
