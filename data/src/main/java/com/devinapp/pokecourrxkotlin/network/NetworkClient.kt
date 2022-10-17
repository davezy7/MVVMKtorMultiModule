package com.devinapp.pokecourrxkotlin.network

import com.devinapp.pokecourrxkotlin.utils.Constants.BASE_PATH
import com.devinapp.pokecourrxkotlin.utils.Constants.BASE_URL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.observer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
import timber.log.Timber
import java.text.DateFormat
import javax.inject.Singleton

@Singleton
class NetworkClient {
    private val ktorHttpClient = HttpClient(CIO) {

        install(Logging) {
            level = LogLevel.BODY
            logger = object : Logger {
                override fun log(message: String) {
                    Timber.tag("Logger Ktor =>").v(message)
                }
            }
        }

        install(ContentNegotiation) {
            gson(contentType = ContentType.Application.Json) {
                setDateFormat(DateFormat.LONG)
                setPrettyPrinting()
            }
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 10000L
            connectTimeoutMillis = 10000L
            socketTimeoutMillis = 10000L
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            accept(ContentType.Application.Json)
            url {
                protocol = URLProtocol.HTTPS
                host = BASE_URL
                path(BASE_PATH)
            }
        }

        install(ResponseObserver) {
            onResponse { response ->
                Timber.tag("HTTP status").d(response.status.value.toString())
            }
        }

        install(HttpCache)
    }

    fun getClient() = ktorHttpClient

    suspend inline fun get(endpoint: String, query: HashMap<String, String> = hashMapOf()): HttpResponse {
        val response = getClient().get(endpoint) {
            query.forEach { q -> parameter(q.key, q.value) }
        }
        return response
    }
}