package com.example.victorymobile.ui.components.form

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp

@Composable
fun FormPasswordField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    label: String
) {
    Spacer(Modifier.height(12.dp))
    FormLabel(text = label)
    val passwordHidden = remember { mutableStateOf(true) }
    OutlinedSecureTextField(
        modifier = Modifier
            .fillMaxWidth()
            .scale(scaleY = 0.9F, scaleX = 1F),
        state = state,
        placeholder = { Text(text = "12345678") },
        shape = RoundedCornerShape(6.dp),
        trailingIcon = {
            IconButton(onClick = { passwordHidden.value = !passwordHidden.value }) {
                Icon(
                    imageVector = if (passwordHidden.value) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = ""
                )
            }
        },
        textObfuscationMode = if (passwordHidden.value) TextObfuscationMode.Hidden else TextObfuscationMode.Visible
    )
}