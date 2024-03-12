package com.example.cfttest.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Name (
    @SerialName(value = "title")
    val title: String,
    @SerialName(value = "first")
    val first: String,
    @SerialName(value = "last")
    val last: String
)