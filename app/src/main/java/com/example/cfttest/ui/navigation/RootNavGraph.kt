package com.example.cfttest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cfttest.domain.models.UserInfoViewModel
import com.example.cfttest.domain.models.UsersViewModel
import com.example.cfttest.ui.screens.UserDetailsScreen
import com.example.cfttest.ui.screens.UsersListScreen

@Composable
fun RootNavGraph(navController: NavHostController, usersViewModel: UsersViewModel) {
    val userInfoModel: UserInfoViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Graph.ROOT
    ) {
        composable(route = Graph.ROOT) {
            UsersListScreen(
                navHostController = navController,
                userInfoViewModel = userInfoModel,
                usersViewModel = usersViewModel
            )
        }
        composable(route = Graph.DETAILS) {
            UserDetailsScreen(userInfoViewModel = userInfoModel)
        }
    }
}

object Graph {
    const val ROOT = "root"
    const val DETAILS = "details"
}