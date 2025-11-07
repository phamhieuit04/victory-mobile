package com.example.victorymobile.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int?,
    val role: Int?,
    val name: String?,
    val email: String?,
    val avatar: String?,
    val phone: Int?,
    val address: String?
)
