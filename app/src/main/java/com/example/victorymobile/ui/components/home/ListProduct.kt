package com.example.victorymobile.ui.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.victorymobile.models.Product

@Composable
fun ListProduct(
    onNavigateToProductDetail: (Int) -> Unit,
    modifier: Modifier = Modifier,
    products: List<Product>
) {
    Column(modifier = modifier.fillMaxWidth()) {
        SectionHeader(title = "Sản phẩm nổi bật", onClick = {})
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.heightIn(max = 2000.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(products) { item ->
                ProductItem(item = item, onClick = {
                    onNavigateToProductDetail(item.id)
                })
            }
        }
    }
}