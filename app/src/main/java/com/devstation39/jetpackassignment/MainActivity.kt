package com.devstation39.jetpackassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.devstation39.jetpackassignment.ui.LoginScreen
import com.devstation39.jetpackassignment.ui.RegistrationScreen
import com.devstation39.jetpackassignment.ui.theme.JetpackAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackAssignmentTheme {
                SetupNavController()
            }
        }
    }

    @Composable
    fun SetupNavController () {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination ="login"){
            composable("login"){
                LoginScreen(navController)
            }
            composable("registration") {
                RegistrationScreen(navController)
            }
        }
    }
}
