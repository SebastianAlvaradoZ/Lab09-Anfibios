package com.example.anfibios.data

import retrofit2.http.GET

interface AnfibiosApiService {

    // GET https://android-kotlin-fun-mars-server.appspot.com/amphibians
    @GET("amphibians")
    suspend fun getAnfibios(): List<Anfibio>
}
