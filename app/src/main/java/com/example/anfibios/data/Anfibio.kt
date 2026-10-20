package com.example.anfibios.data

import com.google.gson.annotations.SerializedName

// Un anfibio tal como lo devuelve la API:
// { "name": "...", "type": "Toad", "description": "...", "img_src": "https://..." }
data class Anfibio(
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("description") val description: String,
    @SerializedName("img_src") val imgSrc: String   // en el JSON la clave es "img_src"
)
