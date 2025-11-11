package com.example.victorymobile.ui.components.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.victorymobile.R

@Composable
fun ShopBanner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(180.dp)
            .padding(top = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentDescription = "",
            painter = painterResource(R.drawable.shop_banner),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Victory Store", modifier = Modifier.padding(start = 16.dp),
            fontSize = 24.sp, fontWeight = FontWeight.Bold,
            color = Color(0xffb96459)
        )
    }
}