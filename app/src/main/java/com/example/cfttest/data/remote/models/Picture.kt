package com.example.cfttest.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Picture (
    @SerialName(value = "large")
    val large: String,
    @SerialName(value = "medium")
    val medium: String,
    @SerialName(value = "thumbnail")
    val thumbnail: String
)