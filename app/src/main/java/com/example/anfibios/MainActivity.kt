package com.example.anfibios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.anfibios.ui.ScreenAnfibios
import com.example.anfibios.ui.theme.AnfibiosTheme
import com.example.anfibios.viewmodel.AnfibiosViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()   // la app dibuja detrás de las barras del sistema
        setContent {
            AnfibiosTheme {
                // Surface define el fondo y el color por defecto de los textos
                Surface(color = MaterialTheme.colorScheme.background) {
                    // El ViewModel sobrevive a rotaciones de pantalla
                    val viewModel: AnfibiosViewModel = viewModel()
                    ScreenAnfibios(viewModel)
                }
            }
        }
    }
}
