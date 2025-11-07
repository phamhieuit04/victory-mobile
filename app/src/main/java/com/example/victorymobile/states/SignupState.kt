package com.example.victorymobile.states

import androidx.compose.foundation.text.input.TextFieldState

data class SignupState(
    var username: TextFieldState = TextFieldState(initialText = "admin"),
    var email: TextFieldState = TextFieldState(initialText = "admin@gmail.com"),
    var password: TextFieldState = TextFieldState(initialText = "12345678"),
    var passwordConfirmation: TextFieldState = TextFieldState(initialText = "12345678"),
    var isSignupDone: Boolean = false,
    var isLoading: Boolean = false,
    var errorMessage: String? = null
)
