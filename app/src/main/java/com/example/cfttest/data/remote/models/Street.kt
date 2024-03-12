package com.example.cfttest.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class Street(
    val number: Int,
    val name: String
)