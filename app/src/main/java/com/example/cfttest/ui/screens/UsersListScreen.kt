package com.example.cfttest.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cfttest.domain.models.UserInfoViewModel
import com.example.cfttest.domain.models.UsersViewModel
import com.example.cfttest.ui.components.UserCard
import com.example.cfttest.ui.navigation.Graph

@Composable
fun UsersListScreen(
    navHostController: NavHostController,
    userInfoViewModel: UserInfoViewModel,
    usersViewModel: UsersViewModel
) {
    val users = usersViewModel.users

    LazyColumn(
        modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(users) { user ->
            UserCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clickable {
                       userInfoViewModel.addUserInfo(user)
                        navHostController.navigate(Graph.DETAILS)
                    },
                user = user
            )
        }
    }
}