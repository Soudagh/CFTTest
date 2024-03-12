package com.example.cfttest.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    @SerialName(value = "gender")
    val gender: String,
    @SerialName(value = "location")
    val location: Location,
    @SerialName(value = "name")
    val name: Name,
    @SerialName(value = "email")
    val email: String,
    @SerialName(value = "login")
    val login: Login,
    @SerialName(value = "dob")
    val dob: Dob,
    @SerialName(value = "registered")
    val registered: Registered,
    @SerialName(value = "phone")
    val phone: String,
    @SerialName(value = "cell")
    val cell: String,
    @SerialName(value = "id")
    val id: Id,
    @SerialName(value = "picture")
    val picture: Picture,
    @SerialName(value = "nat")
    val nat: String
)