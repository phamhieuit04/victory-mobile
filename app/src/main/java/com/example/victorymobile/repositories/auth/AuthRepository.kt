package com.example.victorymobile.repositories.auth

import android.util.Log
import com.example.victorymobile.contracts.repositories.AuthRepositoryInterface
import com.example.victorymobile.helpers.JsonHelper
import com.example.victorymobile.models.User
import com.example.victorymobile.repositories.base.BaseRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.submitForm
import io.ktor.http.parameters
import javax.inject.Inject

class AuthRepository @Inject constructor(
    httpClient: HttpClient
) : BaseRepository(httpClient = httpClient), AuthRepositoryInterface {

    override suspend fun login(email: String, password: String): Map<String, Any?>? {
        try {
            val response = httpClient.submitForm(
                "$baseUrl/login",
                formParameters = parameters {
                    append(name = "email", value = email)
                    append(name = "password", value = password)
                })
            if (response.status.value != 200) return null

            val body: String = response.body()
            val user =
                JsonHelper.parseJson(from = body, to = User::class, key = "user")
            val token = JsonHelper.getDataFromBody(body = body)["token"].toString()

            return mapOf("user" to user, "token" to token)
        } catch (e: Exception) {
            Log.i("MyApp", e.message.toString())

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