# Puntos adicionales – Laboratorio 09: App de Anfibios

Aplicación Android (Kotlin + Jetpack Compose) del reto "Amphibians" que consume
https://android-kotlin-fun-mars-server.appspot.com/amphibians con Retrofit, Gson y Coil.

## Funcionalidades
- Lista con scroll de anfibios: foto, nombre, tipo y descripción
- Estados de carga, éxito y error (con botón "Reintentar")

## Arquitectura (MVVM)
- `data/`: `Anfibio`, `AnfibiosApiService`, `AnfibiosRepository` (capa de datos)
- `viewmodel/`: `AnfibiosViewModel` (estado con `StateFlow`)
- `ui/`: pantalla y tarjeta de Jetpack Compose (solo observan el estado)

## Autor
SebastianAlvaradoZ
