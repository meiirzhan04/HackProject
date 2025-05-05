package com.example.sxodimsduu.mainscreens

import androidx.compose.foundation.Image
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.Text
import androidx.compose.material.ripple
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sxodimsduu.R
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.sxodimsduu.login.CustomButton

@Composable
fun EditProfile(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF_1F1D2B))
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(42.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier.clickable(
                    onClick = { navController.popBackStack() },
                    indication = ripple(bounded = true),
                    interactionSource = null
                )
            )
            Text(
                text = "Edit Profile",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = null,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(100.dp))
                .size(64.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Manas",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "manas.esendikov@sdu.edu.kz",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF_B1B1B1)
        )
        Spacer(modifier = Modifier.height(40.dp))
        CustomTextField(
            placeholder = "Name",
            value = name,
            onValueChange = { name = it }
        )
        Spacer(modifier = Modifier.height(24.dp))
        CustomTextField(
            placeholder = "Email",
            value = email,
            onValueChange = { email = it }
        )
        Spacer(modifier = Modifier.height(24.dp))
        CustomTextField(
            placeholder = "Password",
            value = password,
            onValueChange = { password = it },
        )
        Spacer(modifier = Modifier.height(24.dp))
        CustomTextField(
            placeholder = "Phone Number",
            value = phoneNumber,
            onValueChange = { phoneNumber = it }
        )
        Spacer(modifier = Modifier.height(40.dp))
        CustomButton(
            text = "Save Changes",
            onClick = {

            }
        )
    }
}


@Composable
fun CustomTextField(
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    androidx.compose.material3.OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        shape = RoundedCornerShape(24.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF_252836),
            unfocusedBorderColor = Color(0xFF_252836),
            focusedTextColor = Color(0xFF_92929D),
            unfocusedTextColor = Color(0xFF_92929D),
            focusedLabelColor = Color(0xFF_EBEBEF)
        ),
        visualTransformation = if (placeholder.equals("Password")) PasswordVisualTransformation() else VisualTransformation.None,
        placeholder = {
            Text(
                text = placeholder,
                color = Color(0xFF_92929D)
            )
        }
    )
}
