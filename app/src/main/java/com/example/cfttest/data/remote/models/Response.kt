package com.example.cfttest.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val results: List<UserInfo>,
    val info: Info
)