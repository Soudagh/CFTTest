package com.example.cfttest.data.remote

import android.util.Log
import com.example.cfttest.data.remote.models.Response
import com.example.cfttest.data.remote.models.UserInfo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.serialization.kotlinx.json.json

class Client {
    private val client = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getUsers(): List<UserInfo> {
        return try {
            client.get { url("https://randomuser.me/api/?results=100") }.body<Response>().results
        } catch (e: RedirectResponseException) {
            Log.d("error", e.response.status.description)
            emptyList()
        } catch (e: ClientRequestException) {
            Log.d("error", e.response.status.description)
            emptyList()
        } catch (e: ServerResponseException) {
            Log.d("error", e.response.status.description)
            emptyList()
        } catch (e: Exception) {
            Log.d("error", e.message.toString())
            emptyList()
        }
    }
}