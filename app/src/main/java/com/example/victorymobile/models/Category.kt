package com.example.victorymobile.models

import androidx.compose.ui.graphics.painter.Painter

data class Category(
    var id: Int = 0,
    var title: String,
    var thumbnail: Painter
)
