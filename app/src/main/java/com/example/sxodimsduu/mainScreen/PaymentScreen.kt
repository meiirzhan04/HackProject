package com.example.sxodimsduu.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnitType.Companion.Sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sxodimsduu.R

enum class PaymentMethod { Cash, Card }

@Composable
fun PaymentScreen(navController: NavController) {
    var selectedMethod by remember { mutableStateOf(PaymentMethod.Cash) }
    var cardNumber by remember { mutableStateOf("") }
    var expiry by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

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
                shape = RoundedCornerShape(8.dp)
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
                placeholder = { Text("08/24",color = Color(0xFF_92929D) ) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color(0xFF_92929D)
                ),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )

            OutlinedTextField(
                value = cvv,
                onValueChange = {
                    cvv = it.filter(Char::isDigit).take(3)
                },
                label = { Text("CVV", color = Color(0xFF_92929D)) },
                placeholder = { Text("***",color = Color(0xFF_92929D) ) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.5f),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color(0xFF_92929D)
                ),
                shape = RoundedCornerShape(8.dp)
            )
        }

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = { /* TODO */ },
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