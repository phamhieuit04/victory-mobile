package com.example.victorymobile.states

import androidx.compose.runtime.mutableStateListOf
import com.example.victorymobile.ui.screens.cart.CartItem

object CartState {
    val currentCart = mutableStateListOf<CartItem>()
}