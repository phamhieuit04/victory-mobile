package com.example.victorymobile.ui.components.shop

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun ProductDetailButtons(
    modifier: Modifier = Modifier,
    onAddToCart: () -> Unit,
    onNavigateToCheckOut: () -> Unit
) {
    Spacer(Modifier.height(16.dp))

    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            onClick = onNavigateToCheckOut,
            shape = RectangleShape,
            border = BorderStroke(width = 2.dp, color = Color(0xff3449ca))
        ) {
            Text(text = "Mua ngay")
        }

        Spacer(Modifier.height(12.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            onClick = onAddToCart,
            shape = RectangleShape,
            border = BorderStroke(width = 2.dp, color = Color(0xff3449ca))
        ) {
            Icon(contentDescription = "", imageVector = Icons.Default.ShoppingCart)
            Spacer(Modifier.width(8.dp))
            Text(text = "Thêm vào giỏ hàng")
        }
    }
}