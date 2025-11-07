package com.example.victorymobile.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.victorymobile.ui.components.form.FormButton
import com.example.victorymobile.ui.components.form.FormFooter
import com.example.victorymobile.ui.components.form.FormPasswordField
import com.example.victorymobile.ui.components.form.FormSocialMethods
import com.example.victorymobile.ui.components.form.FormTextField
import com.example.victorymobile.ui.components.form.FormTitle
import com.example.victorymobile.viewmodels.AuthViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = hiltViewModel<AuthViewModel>(),
    onNavigateToSignUp: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val loginState = viewModel.loginState.collectAsStateWithLifecycle()

    LaunchedEffect(loginState.value.isLoggedIn) {
        if (loginState.value.isLoggedIn) {
            onNavigateToHome()
        }
    }

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
            LoginForm(
                emailState = loginState.value.email,
                passwordState = loginState.value.password,
                onSubmit = { viewModel.processLogin() }
            )
        }
    }
}

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    emailState: TextFieldState,
    passwordState: TextFieldState,
    onSubmit: () -> Unit
) {
    Column() {
        FormTitle(title = "Chào mừng bạn quay trở lại", fontSize = 38.sp)
        FormTextField(
            state = emailState,
            label = "Địa chỉ email",
            placeholder = "example@gmail.com"
        )
        FormPasswordField(
            state = passwordState,
            label = "Mật khẩu"
        )
        FormButton(onClick = onSubmit, text = "Tiếp theo")
        FormSocialMethods(text = "Tiếp tục")
    }
}