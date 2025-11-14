package com.example.victorymobile.models

import androidx.compose.ui.graphics.painter.Painter

data class Feedback(
    var id: Int = 0,
    var userName: String,
    var userAvatar: Painter,
    var score: Int,
    var comment: String,
    var time: String
)
