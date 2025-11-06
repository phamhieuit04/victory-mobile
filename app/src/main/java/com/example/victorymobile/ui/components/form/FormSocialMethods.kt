package com.example.victorymobile.ui.components.form

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.victorymobile.R

@Composable
fun FormSocialMethods(modifier: Modifier = Modifier, text: String) {
    Column() {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "hoặc",
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
        Spacer(Modifier.height(12.dp))

        SocialMethodItem(
            onClick = {},
            text = text,
            provider = "Google",
            painter = painterResource(R.drawable.google_logo)
        )
    }
}

@Composable
fun SocialMethodItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    provider: String,
    painter: Painter
) {
    OutlinedButton(
        onClick = onClick,
        contentPadding = PaddingValues(top = 14.dp, bottom = 14.dp, start = 24.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.CenterStart
        ) {
            Image(
                modifier = Modifier.size(28.dp),
                alignment = Alignment.CenterStart,
                contentDescription = "", painter = painter
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "$text bằng $provider",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}