package com.example.victorymobile.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.victorymobile.R

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()

    Scaffold(
        modifier = modifier.background(color = Color.White),
        bottomBar = {
            BottomContent()
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Đăng ký để mua hàng",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 58.sp
            )
            Spacer(Modifier.height(40.dp))

            LoginForm(emailState = emailState, passwordState = passwordState)
            SocialMethods()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview(modifier: Modifier = Modifier) {
    LoginScreen()
}

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    emailState: TextFieldState,
    passwordState: TextFieldState
) {
    Column() {
        FormLabel(text = "Địa chỉ email")
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .scale(scaleY = 0.9F, scaleX = 1F),
            state = emailState,
            placeholder = { Text(text = "example@gmail.com") },
            shape = RoundedCornerShape(6.dp)
        )
        Spacer(Modifier.height(12.dp))

        FormLabel(text = "Mật khẩu")
        OutlinedSecureTextField(
            modifier = Modifier
                .fillMaxWidth()
                .scale(scaleY = 0.9F, scaleX = 1F),
            state = passwordState,
            placeholder = { Text(text = "12345678") },
            shape = RoundedCornerShape(6.dp)
        )
        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff3449ca)
            )
        ) {
            Text(
                text = "Tiếp theo",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        Spacer(Modifier.height(12.dp))
    }
}

@Composable
fun FormLabel(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    )
}

@Composable
fun SocialMethods(modifier: Modifier = Modifier) {
    Column() {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "hoặc",
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
        Spacer(Modifier.height(12.dp))

        OutlinedButton(
            onClick = {},
            contentPadding = PaddingValues(top = 14.dp, bottom = 14.dp, start = 24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                contentAlignment = Alignment.CenterStart
            ) {
                Image(
                    modifier = Modifier.size(28.dp),
                    alignment = Alignment.CenterStart,
                    contentDescription = "", painter = painterResource(R.drawable.google_logo)
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Đăng ký bằng Google",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun BottomContent(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Bạn đã có tài khoản?", fontSize = 14.sp)
        TextButton(onClick = {}) {
            Text(
                text = "Đăng nhập",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}