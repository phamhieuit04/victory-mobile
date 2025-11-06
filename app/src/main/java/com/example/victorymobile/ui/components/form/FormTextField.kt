package com.example.victorymobile.ui.components.form

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp

@Composable
fun FormTextField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    label: String,
    placeholder: String
) {
    FormLabel(text = label)
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .scale(scaleY = 0.9F, scaleX = 1F),
        state = state,
        placeholder = { Text(text = placeholder) },
        shape = RoundedCornerShape(6.dp)
    )
    Spacer(Modifier.height(12.dp))
}