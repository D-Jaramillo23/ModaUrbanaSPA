package com.modaurbana.spa.ui.navigation

import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
            Column (modifier = Modifier.padding(16.dp)) {
                Text("Login (temporal", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(16.dp))
                Button(onClick = { nav.navigate(Routes.Register)}) {
                    Text("Ir a Register")
                }
                Spacer(Modifier.height(8.dp))
                Button(onClick = { nav.navigate(Routes.Home)}) {
                    Text("Entrar (temporal)")
                }

            }
        }
        composable(Routes.Register){
            Column (modifier = Modifier.padding(16.dp)){
                Text("Register (temporal)", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(16.dp))
                Button(onClick = { nav.popBackStack()}){
                    Text("Volver a Login")
                }
                Spacer(Modifier.height(8.dp))
                Button(onClick = { nav.navigate(Routes.Login)}) {
                    Text("Registrarme (Temporal)")
                }
            }
        }
        composable(Routes.Home) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Home (temporal)", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(16.dp))
                Button(onClick = { nav.navigate(Routes.Profile)}) {
                    Text("Ir a profile")
                }
                Spacer(Modifier.height(8.dp))
                Button(onClick = {
                    nav.navigate(Routes.Login) {
                        popUpTo(Routes.Home) { inclusive = true }
                    }
                }) {
                    Text("Logout(Temporal)")
                }
            }
        }
        composable(Routes.Profile) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Profile (temporal)",style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(16.dp))
                Button(onClick = { nav.popBackStack() }) {
                    Text("Volver")
                }
            }
        }
    }
}