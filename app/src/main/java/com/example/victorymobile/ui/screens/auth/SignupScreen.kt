package com.example.victorymobile.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.victorymobile.helpers.ObserverAsEvents
import com.example.victorymobile.ui.NavigationEvent
import com.example.victorymobile.ui.components.form.FormButton
import com.example.victorymobile.ui.components.form.FormErrorText
import com.example.victorymobile.ui.components.form.FormFooter
import com.example.victorymobile.ui.components.form.FormPasswordField
import com.example.victorymobile.ui.components.form.FormSocialMethods
import com.example.victorymobile.ui.components.form.FormTextField
import com.example.victorymobile.ui.components.form.FormTitle
import com.example.victorymobile.viewmodels.AuthViewModel
import kotlinx.serialization.Serializable


@Serializable
object StepOne

@Serializable
object StepTwo

@Composable
fun SignupScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = hiltViewModel<AuthViewModel>(),
    onNavigateToLogin: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val context = LocalContext.current
    val signupState = viewModel.signupState.collectAsStateWithLifecycle()

    ObserverAsEvents(viewModel.navigationChannel) { event ->
        when (event) {
            is NavigationEvent.NavigateToLogin -> {
                onNavigateToLogin()
            }

            is NavigationEvent.NavigateToHome -> {
                onNavigateToHome()
            }
        }
    }

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
                usernameState = signupState.value.username,
                emailState = signupState.value.email,
                passwordState = signupState.value.password,
                passwordConfirmationState = signupState.value.passwordConfirmation,
                onSubmit = { viewModel.processSignup() },
                onGoogleSignIn = { viewModel.processGoogleSignIn(context = context) },
                isLoading = signupState.value.isLoading,
                errorMessage = signupState.value.errorMessage
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
    onSubmit: () -> Unit,
    onGoogleSignIn: () -> Unit,
    isLoading: Boolean = false,
    errorMessage: String? = null
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
                    onClick = onSubmit,
                    passwordState = passwordState,
                    passwordConfirmationState = passwordConfirmationState,
                    isLoading = isLoading,
                    errorMessage = errorMessage
                )
            }
        }
        FormSocialMethods(text = "Đăng ký", onGoogleSignIn = onGoogleSignIn)
    }
}

@Composable
fun SignupStepOne(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    usernameState: TextFieldState,
    emailState: TextFieldState
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
    passwordConfirmationState: TextFieldState,
    isLoading: Boolean = false,
    errorMessage: String? = null
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
        if (errorMessage != null) FormErrorText(message = errorMessage)
        FormButton(
            onClick = onClick,
            text = "Đăng ký",
            isLoading = isLoading
        )
    }
}