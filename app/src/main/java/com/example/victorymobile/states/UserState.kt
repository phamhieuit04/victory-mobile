package com.example.victorymobile.states

import com.example.victorymobile.models.User

data class UserState(
    var currentUser: User? = null,
    var accessToken: String? = null
)