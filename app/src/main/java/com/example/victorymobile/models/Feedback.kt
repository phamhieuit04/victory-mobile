package com.example.victorymobile.models

data class Feedback(
    var id: Int = 0,
    var userName: String,
    var score: Int,
    var comment: String,
    var time: String
)
