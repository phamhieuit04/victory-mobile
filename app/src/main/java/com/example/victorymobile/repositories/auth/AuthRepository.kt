package com.example.victorymobile.repositories.auth

import android.util.Log
import com.example.victorymobile.contracts.repositories.AuthRepositoryInterface
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.submitForm
import io.ktor.client.statement.HttpResponse
import io.ktor.http.parameters
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val httpClient: HttpClient
) : AuthRepositoryInterface {

    override suspend fun login(email: String, password: String): HttpResponse? {
        try {
            return httpClient.submitForm(
                url = "login",
                formParameters = parameters {
                    append(name = "email", value = email)
                    append(name = "password", value = password)
                })
        } catch (e: Exception) {
            Log.i("MyApp", e.toString())

            return null
        }
    }

    override suspend fun signup(
        name: String,
        email: String,
        password: String,
        passwordConfirmation: String
    ): Any? {
        return null
    }
}