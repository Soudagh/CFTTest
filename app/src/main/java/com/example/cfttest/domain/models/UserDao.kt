package com.example.cfttest.domain.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Insert
    fun insertUser(vararg user: User)

    @Query("DELETE FROM users")
    fun deleteAllUsers()
}