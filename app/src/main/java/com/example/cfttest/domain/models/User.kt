package com.example.cfttest.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "location") val location: String,
    @ColumnInfo(name = "longitude") val longitude: String,
    @ColumnInfo(name = "latitude") val latitude: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "login") val login: String,
    @ColumnInfo(name = "dob") val dob: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "registered") val registered: String,
    @ColumnInfo(name = "registered_age") val registeredAge: Int,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "cell") val cell: String,
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "picture") val picture: String,
    @ColumnInfo(name = "nat") val nat: String

)