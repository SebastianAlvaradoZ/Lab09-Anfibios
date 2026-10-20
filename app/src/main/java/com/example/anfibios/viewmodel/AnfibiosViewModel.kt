package com.example.anfibios.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anfibios.data.Anfibio
import com.example.anfibios.data.AnfibiosRepository
import com.example.anfibios.data.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// Los tres estados posibles de la pantalla
sealed interface AnfibiosUiState {
    data object Cargando : AnfibiosUiState
    data class Exito(val anfibios: List<Anfibio>) : AnfibiosUiState
    data class Error(val mensaje: String) : AnfibiosUiState
}

class AnfibiosViewModel : ViewModel() {

    private val repositorio = AnfibiosRepository(RetrofitClient.api)

    // Estado privado y mutable; la UI solo ve la versión de solo lectura
    private val _uiState = MutableStateFlow<AnfibiosUiState>(AnfibiosUiState.Cargando)
    val uiState: StateFlow<AnfibiosUiState> = _uiState

    init {
        cargarAnfibios()   // se piden los datos apenas se crea el ViewModel
    }

    fun cargarAnfibios() {
        viewModelScope.launch {
            _uiState.value = AnfibiosUiState.Cargando
            _uiState.value = try {
                AnfibiosUiState.Exito(repositorio.obtenerAnfibios())
            } catch (e: Exception) {
                AnfibiosUiState.Error("No se pudo cargar: ${e.message}")
            }
        }
    }
}
