package com.example.victorymobile.contracts.repositories

interface AuthRepositoryInterface {
    suspend fun login(email: String, password: String): Map<String, Any?>?
    suspend fun signup(
        name: String,
        email: String,
        password: String,
        passwordConfirmation: String
    ): Any?
}