package com.example.cfttest.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Registered(
    @SerialName(value = "date")
    val date: String,
    @SerialName(value = "age")
    val age: Int
)