package com.example.victorymobile.ui.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.victorymobile.models.Product

@Composable
fun TopSellers(modifier: Modifier = Modifier, topSellerProducts: List<Product>) {
    Column(modifier = modifier.fillMaxWidth()) {
        SectionHeader(title = "Sản phẩm bán chạy", onClick = {})
        Spacer(Modifier.height(2.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            items(topSellerProducts) { product ->
                TopSellerItem(item = product)
            }
        }
    }
}