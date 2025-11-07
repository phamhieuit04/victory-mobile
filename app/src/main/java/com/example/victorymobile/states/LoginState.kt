package com.example.victorymobile.states

import androidx.compose.foundation.text.input.TextFieldState

data class LoginState(
    var email: TextFieldState = TextFieldState(initialText = "tomnguyenhieu2004@gmail.com"),
    var password: TextFieldState = TextFieldState(initialText = "12345678"),
    var isLoggedIn: Boolean = false
)