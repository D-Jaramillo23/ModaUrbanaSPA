package com.example.modaurbanaspa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.modaurbanaspa.ui.theme.ModaUrbanaSPATheme
import com.modaurbana.spa.ui.navigation.AppNav

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModaUrbanaSPATheme {
                AppNav()
            }
        }
    }
}
