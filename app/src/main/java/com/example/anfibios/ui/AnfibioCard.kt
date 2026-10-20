package com.example.anfibios.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.anfibios.data.Anfibio

// Tarjeta de un anfibio: foto, nombre, tipo y descripción
@Composable
fun AnfibioCard(anfibio: Anfibio, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        // Coil descarga y muestra la imagen desde la URL del API
        AsyncImage(
            model = anfibio.imgSrc,
            contentDescription = anfibio.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = anfibio.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))

            // Pastilla con el tipo de anfibio (Toad, Frog, Salamander...)
            Surface(
                shape = RoundedCornerShape(50),
                color = MaterialTheme.colorScheme.secondary
            ) {
                Text(
                    text = anfibio.type,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }

            Spacer(Modifier.height(12.dp))
            Text(
                text = anfibio.description,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
