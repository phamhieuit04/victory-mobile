package com.example.victorymobile.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class Product(
    var id: Int = 0,
    var title: String = "",
    var score: Int = 0,
    var description: String = "",
    var price: String = "",
    var thumbnail: Painter? = null,
    var backgroundColor: Color? = null,
    var quantity: Int? = null
)
