package com.modaurbana.spa.ui.screens


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.modaurbana.spa.ui.theme.AppColors
import com.modaurbana.spa.ui.theme.AppTypography
import androidx.compose.material3.TopAppBarDefaults


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ProfileScreen(
    onBack: () -> Unit
) {
    Scaffold (
        containerColor = AppColors.RegisterBg,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Perfil")},
                navigationIcon = { TextButton(onClick = onBack) {Text("Volver") }},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = AppColors.OnScreenBg,
                    titleContentColor = AppColors.OnScreenBg
            )
            )}
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