package com.example.victorymobile.ui.components.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Victory Store",
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            style = MaterialTheme.typography.titleLarge.copy(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )
        )
        IconButton(onClick = {}) {
            Icon(
                modifier = Modifier.size(28.dp),
                contentDescription = "",
                imageVector = Icons.Default.Menu
            )
        }
    }
}