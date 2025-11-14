package com.example.victorymobile.ui.components.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.victorymobile.models.Feedback

@Composable
fun ProductDetailFeedbackHeader(modifier: Modifier = Modifier, totalFeedback: Int) {
    Text(
        text = "Đánh giá của khách hàng ($totalFeedback)",
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun ProductDetailFeedback(modifier: Modifier = Modifier, feedback: Feedback) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    contentDescription = "",
                    painter = feedback.userAvatar,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column() {
                    Text(text = feedback.userName, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = feedback.time, fontSize = 11.sp, color = Color.Gray)
                }
            }
            Row() {
                for (i in 0..feedback.score) {
                    Icon(
                        modifier = Modifier.size(11.dp),
                        contentDescription = "",
                        imageVector = Icons.Default.Star,
                        tint = Color(0xffffa132)
                    )
                }
            }
        }
        Text(
            text = feedback.comment,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            fontSize = 14.sp,
            lineHeight = 24.sp
        )
        Spacer(Modifier.height(4.dp))
    }
}