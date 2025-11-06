package com.modaurbana.spa.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController




@Composable
fun AppNav() {
    val nav = rememberNavController()


    NavHost(
        navController = nav,
        startDestination = Routes.Login
    ) {
        composable(Routes.Login){
            androidx.compose.material3.Text("Login (Temporal)")
        }
        composable(Routes.Register){
            androidx.compose.material3.Text("Register (temporal)")
        }
        composable(Routes.Home) {
            androidx.compose.material3.Text("Home (temporal")
        }
        composable(Routes.Profile) {
            androidx.compose.material3.Text("Profile (temporal")
        }
    }
}