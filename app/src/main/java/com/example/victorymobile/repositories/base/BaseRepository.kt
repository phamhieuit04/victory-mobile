package com.example.victorymobile.repositories.base

import io.ktor.client.HttpClient
import javax.inject.Inject

open class BaseRepository @Inject constructor(
    protected val httpClient: HttpClient
) {
    protected val baseUrl: String = "http://10.0.2.2:8000/api"
}