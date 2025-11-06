package com.example.victorymobile.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.victorymobile.ui.components.form.FormButton
import com.example.victorymobile.ui.components.form.FormFooter
import com.example.victorymobile.ui.components.form.FormPasswordField
import com.example.victorymobile.ui.components.form.FormSocialMethods
import com.example.victorymobile.ui.components.form.FormTextField
import com.example.victorymobile.ui.components.form.FormTitle

@Composable
fun LoginScreen(modifier: Modifier = Modifier, onNavigateToSignUp: () -> Unit) {
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()

    Scaffold(
        modifier = modifier.background(color = Color.White),
        bottomBar = {
            FormFooter(
                onClick = onNavigateToSignUp,
                title = "Bạn chưa có tài khoản?",
                body = "Đăng ký"
            )
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
            LoginForm(emailState = emailState, passwordState = passwordState)
        }
    }
}

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    emailState: TextFieldState,
    passwordState: TextFieldState,
) {
    Column() {
        FormTitle(title = "Chào mừng bạn quay trở lại", fontSize = 38.sp)
        FormTextField(
            state = emailState,
            label = "Địa chỉ email",
            placeholder = "example@gmail.com"
        )
        FormPasswordField(state = passwordState)
        FormButton(onClick = {}, text = "Tiếp theo")
        FormSocialMethods(text = "Tiếp tục")
    }
}