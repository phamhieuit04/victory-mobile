package com.example.victorymobile.ui.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.victorymobile.ui.screens.home.TopSellerProduct

@Composable
fun TopSellers(modifier: Modifier = Modifier, topSellerProduct: List<TopSellerProduct>) {
    val scrollState = rememberScrollState()

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Sản phẩm bán chạy", fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
            TextButton(onClick = {}) {
                Text(
                    text = "Tất cả sản phẩm",
                    color = Color.Black.copy(alpha = 0.6f),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 14.sp
                )
            }
        }
        Spacer(Modifier.height(2.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            items(topSellerProduct) { product ->
                TopSellerItem(product = product)
            }
        }
    }
}