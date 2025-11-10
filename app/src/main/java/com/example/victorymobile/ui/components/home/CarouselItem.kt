package com.example.victorymobile.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CarouselItem(modifier: Modifier = Modifier, item: SliderItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = item.image,
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.padding(start = 24.dp, top = 12.dp)) {
            Text(
                text = item.label.uppercase(),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = item.title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                modifier = Modifier.width(96.dp),
                lineHeight = 36.sp
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = item.description,
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 10.sp
            )
        }
    }
}