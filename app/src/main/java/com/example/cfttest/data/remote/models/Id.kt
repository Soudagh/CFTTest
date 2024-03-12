package com.example.cfttest.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Id (
    @SerialName(value = "name")
    val name: String,
    @SerialName(value = "value")
    val value: String?
)