package com.example.sxodimsduu.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sxodimsduu.R
import com.example.sxodimsduu.clubs.CustomDragHandle
import com.example.sxodimsduu.clubs.ForgotPasswordBoxes

enum class PaymentMethod { Cash, Card }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(navController: NavController) {
    var showForgotPasswordSheet by remember { mutableStateOf(false) }
    var selectedMethod by remember { mutableStateOf(PaymentMethod.Cash) }
    var cardNumber by remember { mutableStateOf("") }
    var expiry by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }
    val sheetState = rememberModalBottomSheetState()
    if (showForgotPasswordSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showForgotPasswordSheet = false
            },
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            containerColor = Color(0xFF_252836),
            sheetState = sheetState,
            scrimColor = Color.Black.copy(alpha = 0.5f),
            dragHandle = {
                CustomDragHandle()
            },
            content = {
                LazyColumn(
                    modifier = Modifier
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.ic_payment),
                            contentDescription = "Payment",
                            modifier = Modifier.fillMaxWidth(),
                            alignment = Alignment.Center,
                        )
                        Text(
                            text = "Your payment has completed!",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(
                            onClick = {
                                showForgotPasswordSheet = false
                                navController.popBackStack()
                            },
                            modifier = Modifier.align(Alignment.CenterHorizontally).height(60.dp).width(130.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF_12CDD9),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(100.dp)
                        ) {
                            Text(
                                text = "OK",
                                color = Color.White,
                                fontSize = 18.sp
                            )
                        }
                    }
                }
            }
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF_1F1D2B))
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            "Choose the payment",
            fontSize = 24.sp,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(12.dp))

        PaymentOptionBox(
            imageRes = R.drawable.ic_kaspi,
            title = "Kaspi Pay",
            subtitle = "Visa, MasterCard",
            isSelected = (selectedMethod == PaymentMethod.Card),
            onSelect = { selectedMethod = PaymentMethod.Card }
        )
        PaymentOptionBox(
            imageRes = R.drawable.ic_wallet,
            title = "Cash",
            subtitle = "Profile Cash",
            isSelected = (selectedMethod == PaymentMethod.Cash),
            onSelect = { selectedMethod = PaymentMethod.Cash }
        )

        if (selectedMethod == PaymentMethod.Card) {
            OutlinedTextField(
                value = cardNumber,
                onValueChange = {
                    val digits = it.filter(Char::isDigit).take(16)
                    cardNumber = digits.chunked(4).joinToString(" ")
                },
                label = { Text("Card Number", color = Color(0xFF_92929D)) },
                placeholder = { Text("1234 5678 9012 3456", color = Color(0xFF_92929D)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color(0xFF_92929D)
                ),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            )

            OutlinedTextField(
                value = expiry,
                onValueChange = {
                    val digits = it.filter(Char::isDigit).take(4)
                    expiry = when {
                        digits.length <= 2 -> digits
                        else -> digits.substring(0, 2) + "/" + digits.substring(2)
                    }
                },
                label = { Text("Validity Period (MM/YY)", color = Color(0xFF_92929D)) },
                placeholder = { Text("08/24", color = Color(0xFF_92929D)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color(0xFF_92929D)
                ),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            )

            OutlinedTextField(
                value = cvv,
                onValueChange = {
                    cvv = it.filter(Char::isDigit).take(3)
                },
                label = { Text("CVV", color = Color(0xFF_92929D)) },
                placeholder = { Text("***", color = Color(0xFF_92929D)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.5f),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color(0xFF_92929D)
                ),
                shape = RoundedCornerShape(16.dp)
            )
        }

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                showForgotPasswordSheet = true
            },
            enabled = selectedMethod != PaymentMethod.Card ||
                    (cardNumber.replace(" ", "").length == 16
                            && expiry.length == 5
                            && cvv.length == 3),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (
                    selectedMethod != PaymentMethod.Card ||
                    (cardNumber.replace(" ", "").length == 16
                            && expiry.length == 5
                            && cvv.length == 3)
                ) MaterialTheme.colorScheme.primary else Color.Gray,
                disabledContainerColor = Color.DarkGray
            )
        ) {
            Text(
                text = "Pay",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun PaymentOptionBox(
    imageRes: Int,
    title: String,
    subtitle: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
            .background(
                color = if (isSelected) Color.White else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(
                onClick = onSelect,
                indication = ripple(bounded = true),
                interactionSource = remember { androidx.compose.foundation.interaction.MutableInteractionSource() }
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier.size(32.dp)
        )
        Spacer(Modifier.width(12.dp))
        Column {
            Text(
                text = title,
                fontSize = 18.sp,
                color = if (isSelected) MaterialTheme.colorScheme.primary else Color.White
            )
            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = if (isSelected) Color.Gray else Color.White.copy(alpha = 0.7f)
            )
        }
        Spacer(Modifier.weight(1f))
        if (isSelected) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Selected",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}


@Preview
@Composable
fun PaymentScreenPreview() {
    PaymentScreen(navController = NavController(LocalContext.current))
}