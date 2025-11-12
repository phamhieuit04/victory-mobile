package com.example.victorymobile.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.victorymobile.models.Product

@Composable
fun ProductItem(onClick: () -> Unit, modifier: Modifier = Modifier, item: Product) {
    Box(
        modifier = modifier
            .width(180.dp)
            .height(250.dp)
            .padding(bottom = 8.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Color.White)
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(top = 16.dp),
                contentDescription = "",
                painter = item.thumbnail,
                alignment = Alignment.Center
            )
            Column(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp),
            ) {
                Text(
                    text = item.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(3.dp))
                Row() {
                    for (i in 0..item.score) {
                        Icon(
                            contentDescription = "",
                            imageVector = Icons.Default.Star,
                            modifier = Modifier.size(12.dp),
                            tint = Color(0xffffa132)
                        )
                    }
                }
                Spacer(Modifier.height(8.dp))
                Text(text = item.price, fontSize = 12.sp)
            }
        }
    }
}