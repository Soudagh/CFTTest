package com.example.cfttest.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Timezone(
    @SerialName(value = "offset")
    val offset: String,
    @SerialName(value = "description")
    val description: String
)