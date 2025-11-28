package com.example.victorymobile.ui.screens.cart

import androidx.activity.compose.BackHandler
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.victorymobile.states.UiState

@Composable
fun CheckoutScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    productId: Int? = null
) {
    BackHandler {
        UiState.displayTopBar.value = true
        UiState.displayBottomBar.value = true
        onNavigateBack()
    }

    if (productId != null) {
        Text(text = productId.toString())
    } else {
        Text(text = "Checkout screen")
    }
}

@Preview(device = "id:pixel_3", showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun Preview(modifier: Modifier = Modifier) {
    CheckoutScreen(onNavigateBack = {})
}