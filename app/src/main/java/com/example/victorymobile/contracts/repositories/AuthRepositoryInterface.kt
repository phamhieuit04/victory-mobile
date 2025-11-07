package com.example.victorymobile.contracts.repositories

import io.ktor.client.statement.HttpResponse

interface AuthRepositoryInterface {
    suspend fun login(email: String, password: String): HttpResponse?
    suspend fun signup(
        name: String,
        email: String,
        password: String,
        passwordConfirmation: String
    ): Any?
}