package com.example.victorymobile.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class Product(
    var title: String = "",
    var score: Int = 0,
    var description: String = "",
    var price: String = "",
    var thumbnail: Painter,
    var backgroundColor: Color? = null
)
