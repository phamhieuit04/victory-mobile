package com.example.victorymobile.ui.components.shop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
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

@Composable
fun ProductDetailInformation(
    modifier: Modifier = Modifier,
    title: String,
    score: Int,
    price: String,
    description: String
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row() {
                Text(text = "Thể loại: ", color = Color.Gray, fontSize = 11.sp)
                Text(
                    text = "Điện thoại",
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    fontSize = 11.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Row() {
                    for (i in 0..score) {
                        Icon(
                            modifier = Modifier.size(11.dp),
                            contentDescription = "",
                            imageVector = Icons.Default.Star,
                            tint = Color(0xffffa132)
                        )
                    }
                }
                Text(text = "$score.00", color = Color(0xff7c818b), fontSize = 11.sp)
                Text(text = "(1)", color = Color(0xff7c818b), fontSize = 11.sp)
            }
        }
        Spacer(Modifier.height(12.dp))
        Text(text = price, fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(12.dp))
        Text(
            text = description,
            fontSize = 14.sp,
            maxLines = 8,
            lineHeight = 24.sp,
            overflow = TextOverflow.Ellipsis
        )
    }
}