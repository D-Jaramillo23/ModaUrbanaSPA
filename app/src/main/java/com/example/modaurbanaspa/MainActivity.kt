package com.example.modaurbanaspa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.modaurbanaspa.ui.navigation.AppNav
import com.example.modaurbanaspa.ui.theme.ModaUrbanaSPATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModaUrbanaSPATheme {
                setContent {
                    ModaUrbanaSPATheme {
                        AppNav()
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ScreenPreview() {
        ModaUrbanaSPATheme {
            setContent {
                ModaUrbanaSPATheme {
                    AppNav()
                }
            }
        }
    }
}

