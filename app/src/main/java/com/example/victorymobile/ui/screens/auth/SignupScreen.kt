package com.example.victorymobile.ui.screens.auth

import android.util.Log
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.victorymobile.ui.components.form.FormButton
import com.example.victorymobile.ui.components.form.FormFooter
import com.example.victorymobile.ui.components.form.FormPasswordField
import com.example.victorymobile.ui.components.form.FormSocialMethods
import com.example.victorymobile.ui.components.form.FormTextField
import com.example.victorymobile.ui.components.form.FormTitle
import kotlinx.serialization.Serializable


@Serializable
object StepOne

@Serializable
object StepTwo

@Composable
fun SignupScreen(modifier: Modifier = Modifier, onNavigateToLogin: () -> Unit) {
    val usernameState = rememberTextFieldState()
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()
    val passwordConfirmationState = rememberTextFieldState()

    Scaffold(
        modifier = modifier.background(color = Color.White),
        bottomBar = {
            FormFooter(
                onClick = onNavigateToLogin,
                title = "Bạn đã có tài khoản?",
                body = "Đăng nhập"
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
            SignupForm(
                usernameState = usernameState,
                emailState = emailState,
                passwordState = passwordState,
                passwordConfirmationState = passwordConfirmationState
            )
        }
    }
}

@Composable
fun SignupForm(
    modifier: Modifier = Modifier,
    usernameState: TextFieldState,
    emailState: TextFieldState,
    passwordState: TextFieldState,
    passwordConfirmationState: TextFieldState,
) {
    val navController = rememberNavController()

    Column() {
        FormTitle(title = "Đăng ký để bắt đầu mua hàng", fontSize = 40.sp)

        NavHost(navController = navController, startDestination = StepOne) {
            composable<StepOne> {
                SignupStepOne(
                    onClick = { navController.navigate(StepTwo) },
                    usernameState = usernameState,
                    emailState = emailState
                )
            }
            composable<StepTwo> {
                SignupStepTwo(
                    onClick = { Log.i("MyApp", "Navigate to home") },
                    passwordState = passwordState,
                    passwordConfirmationState = passwordConfirmationState
                )
            }
        }
        FormSocialMethods(text = "Đăng ký")
    }
}

@Composable
fun SignupStepOne(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    usernameState: TextFieldState,
    emailState: TextFieldState,
) {
    Column() {
        FormTextField(
            state = usernameState,
            label = "Tên đăng nhập",
            placeholder = "hiupham"
        )
        FormTextField(
            state = emailState,
            label = "Địa chỉ email",
            placeholder = "example@gmail.com"
        )
        FormButton(
            onClick = onClick,
            text = "Tiếp tục"
        )
    }
}

@Composable
fun SignupStepTwo(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    passwordState: TextFieldState,
    passwordConfirmationState: TextFieldState
) {
    Column() {
        FormPasswordField(
            state = passwordState,
            label = "Mật khẩu"
        )
        FormPasswordField(
            state = passwordConfirmationState,
            label = "Nhập lại mật khẩu"
        )
        FormButton(
            onClick = onClick,
            text = "Đăng ký"
        )
    }
}