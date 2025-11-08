package com.modaurbana.spa.ui.navigation

import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.modaurbana.spa.ui.screens.LoginScreen
import com.modaurbana.spa.ui.screens.RegisterScreen
import com.modaurbana.spa.ui.screens.HomeScreen
import com.modaurbana.spa.ui.screens.ProfileScreen



@Composable
fun AppNav() {
    val nav = rememberNavController()

    NavHost(
        navController = nav,
        startDestination = Routes.Login
    ) {
        composable(Routes.Login) {
            LoginScreen(
                onGoRegister = { nav.navigate(Routes.Register) },
                onLoginOk = {
                    nav.navigate(Routes.Home) {
                        popUpTo(Routes.Login) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.Register) {
            RegisterScreen(
                onBackLogin = { nav.popBackStack() },
                onRegisterOk = { nav.navigate(Routes.Login) }
            )
        }

        composable(Routes.Home) {
            HomeScreen(
                onGoProfile = { nav.navigate(Routes.Profile) },
                onLogout = {
                    nav.navigate(Routes.Login) {
                        popUpTo(Routes.Home) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.Profile) {
            ProfileScreen(
                onBack = { nav.popBackStack() }
            )
        }
    }
}
