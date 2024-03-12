package com.example.cfttest.domain.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserInfoViewModel() : ViewModel() {
    var userInfo by mutableStateOf<User?>(null)
        private set

    fun addUserInfo(newUserInfo: User) {
        userInfo = newUserInfo
    }
}