package com.example.victorymobile.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var id: Int? = 0,
    var role: Int? = 1,
    var name: String? = null,
    var email: String? = null,
    var avatar: String? = null,
    var phone: String? = null,
    var address: String? = null
)
