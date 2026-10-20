package com.example.anfibios.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Crea Retrofit una sola vez para toda la app (patrón singleton con "object")
object RetrofitClient {
    private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    val api: AnfibiosApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnfibiosApiService::class.java)
    }
}

// Único punto de acceso a los datos: el ViewModel no conoce Retrofit
class AnfibiosRepository(private val api: AnfibiosApiService) {

    suspend fun obtenerAnfibios(): List<Anfibio> = api.getAnfibios()
}
