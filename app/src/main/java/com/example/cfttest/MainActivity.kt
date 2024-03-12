package com.example.cfttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.cfttest.domain.models.LaunchViewModel
import com.example.cfttest.domain.models.UsersViewModel
import com.example.cfttest.ui.navigation.RootNavGraph
import com.example.cfttest.ui.theme.CFTTestTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var db: AppDatabase
    private lateinit var viewModel: LaunchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = AppDatabase.getInstance(this)
        viewModel = LaunchViewModel(db)
        viewModel.getAllUsers()

        lifecycleScope.launch {
            viewModel.dataFlow.collect { users ->
                setContent {
                    CFTTestTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            val usersModel: UsersViewModel = viewModel()
                            usersModel.addUsers(users)
                            RootNavGraph(navController = rememberNavController(), usersViewModel = usersModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CFTTestTheme {
        Greeting("Android")
    }
}