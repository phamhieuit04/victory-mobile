package com.example.victorymobile.ui.components.form

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle

@Composable
fun FormErrorText(modifier: Modifier = Modifier, message: String) {
    Text(text = message, color = Color.Red, fontStyle = FontStyle.Italic)
}