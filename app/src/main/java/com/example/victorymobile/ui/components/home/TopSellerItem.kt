package com.example.victorymobile.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.victorymobile.ui.screens.home.TopSellerProduct

@Composable
fun TopSellerItem(modifier: Modifier = Modifier, product: TopSellerProduct) {
    Card(
        modifier = Modifier
            .height(320.dp)
            .width(240.dp),
        colors = CardDefaults.cardColors(containerColor = product.backgroundColor),
        onClick = {}
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 20.dp, end = 20.dp, top = 20.dp),
        ) {
            Text(
                text = product.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.height(2.dp))
            Row() {
                for (i in 0..product.score) {
                    Icon(
                        contentDescription = "",
                        imageVector = Icons.Default.Star,
                        modifier = Modifier.size(12.dp),
                        tint = Color.Yellow
                    )
                }
            }
            Spacer(Modifier.height(6.dp))
            Text(
                text = product.description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                lineHeight = 16.sp
            )
        }
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(bottom = 16.dp),
            contentDescription = "",
            painter = product.image,
            alignment = Alignment.Center
        )
    }
}