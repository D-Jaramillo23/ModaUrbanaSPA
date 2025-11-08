package com.modaurbana.spa.ui.screens

import android.R.attr.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreen(
    onGoProfile: () -> Unit,
    onLogout: () -> Unit
){
    Scaffold (
        topBar = {CenterAlignedTopAppBar(title = {Text("Home")})}
    ) {
        padding ->
        Column (
            Modifier.padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
          Text("ModaUrbana", style = MaterialTheme.typography.titleLarge)
            Button(onClick = onGoProfile, modifier = Modifier.fillMaxWidth()) {
                Text("Ir al perfil")
            }
        }
        Button(
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cerrar sesión")
        }
    }
}