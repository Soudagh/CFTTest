package com.example.cfttest.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location (
    @SerialName(value = "street")
    val street: Street,
    @SerialName(value = "city")
    val city: String,
    @SerialName(value = "state")
    val state: String,
    @SerialName(value = "country")
    val country: String,
    @SerialName(value = "postcode")
    val postcode: String,
    @SerialName(value = "coordinates")
    val coordinates: Coordinates,
    @SerialName(value = "timezone")
    val timezone: Timezone

)