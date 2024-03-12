package com.example.cfttest.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coordinates (
    @SerialName(value = "latitude")
    val latitude: String,
    @SerialName(value = "longitude")
    val longitude: String
)