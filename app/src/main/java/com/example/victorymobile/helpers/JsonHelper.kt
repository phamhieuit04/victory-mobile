package com.example.victorymobile.helpers

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

object JsonHelper {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    fun getDataFromBody(body: String): Map<String, JsonElement> {
        val result: Map<String, JsonElement> = json.parseToJsonElement(body).jsonObject
        val data: Map<String, JsonElement> =
            json.parseToJsonElement(result.getValue("data").toString()).jsonObject

        return data
    }

    @OptIn(InternalSerializationApi::class)
    fun <T : Any> parseJson(from: String, to: KClass<T>, key: String): T {
        val data = getDataFromBody(body = from)
        val element = data.getValue(key = key)
        val serializer: KSerializer<T> = to.serializer()

        val result = json.decodeFromJsonElement(deserializer = serializer, element = element)
        return result
    }
}