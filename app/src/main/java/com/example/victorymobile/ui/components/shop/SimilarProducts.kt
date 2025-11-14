package com.example.victorymobile.ui.components.shop

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.victorymobile.models.Product
import com.example.victorymobile.ui.components.home.ProductItem

@Composable
fun SimilarProducts(
    onNavigateToProductDetail: (Int) -> Unit,
    modifier: Modifier = Modifier,
    products: List<Product>
) {
    Text(
        text = "Sản phẩm tương tự", fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold
    )
    Spacer(Modifier.height(16.dp))
    LazyRow() {
        items(products) { product ->
            ProductItem(onClick = { onNavigateToProductDetail(product.id) }, item = product)
        }
    }
}