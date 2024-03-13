package com.example.cfttest.domain.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cfttest.AppDatabase
import com.example.cfttest.data.remote.Client
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class LaunchViewModel(val database: AppDatabase) : ViewModel() {
    private val client = Client()

    private val flow = MutableSharedFlow<List<User>>()
    val dataFlow: SharedFlow<List<User>> = flow

    fun getAllUsers(forceReload: Boolean = false) {
        viewModelScope.launch(Dispatchers.IO) {
            val cachedUsers = database.userDao().getAllUsers()
            if (cachedUsers.isNotEmpty() && !forceReload) {
                flow.emit(cachedUsers)
            } else {
                database.userDao().deleteAllUsers()
                client.getUsers().let { users ->
                    users.forEachIndexed { index, user ->
                        database.userDao().insertUser(
                            User(
                                uid = index,
                                gender = user.gender,
                                location = user.location.postcode + " ${user.location.country}" + " ${user.location.state}" + " ${user.location.city}" + " ${user.location.street.name}" + " ${user.location.street.number}",
                                email = user.email,
                                phone = user.phone,
                                cell = user.cell,
                                id = "${user.id.name} ${user.id.value}",
                                nat = user.nat,
                                dob = user.dob.date.slice(0..9),
                                age = user.dob.age,
                                registered = user.registered.date.slice(0..9),
                                registeredAge = user.registered.age,
                                login = user.login.username,
                                name = "${user.name.first} ${user.name.last}",
                                picture = user.picture.large,
                                longitude = user.location.coordinates.longitude,
                                latitude = user.location.coordinates.latitude
                            )
                        )
                    }
                    flow.emit(database.userDao().getAllUsers())
                }

            }
        }
    }
}