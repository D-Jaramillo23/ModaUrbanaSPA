package com.modaurbana.spa.ui.screens


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ProfileScreen(
    onBack: () -> Unit
) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Perfil")},
                navigationIcon = { TextButton(onClick = onBack) {Text("Volver") }}
            )
        }
    ) {
        padding ->
        Column (
            Modifier.padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            Text("Datos Usuario", style = MaterialTheme.typography.titleLarge)
            Text("Muestra de datos")
        }
    }
}