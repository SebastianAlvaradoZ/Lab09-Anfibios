package com.example.anfibios.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Tema claro fijo: fondo menta y textos oscuros, legible en cualquier equipo
private val LightColorScheme = lightColorScheme(
    primary = VerdeBosque,
    onPrimary = Color.White,
    secondary = Amarillo,
    onSecondary = TextoOscuro,
    background = Menta,
    onBackground = TextoOscuro,
    surface = Color.White,
    onSurface = TextoOscuro,
    surfaceVariant = Color(0xFFDCEDC8),
    onSurfaceVariant = Color(0xFF33472F)
)

@Composable
fun AnfibiosTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
