package com.example.cfttest.domain.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UsersViewModel() : ViewModel() {
    var users by mutableStateOf<List<User>>(listOf())
    private set

    fun addUsers(newUsers: List<User>) {
        users = newUsers
    }
}