package com.aplicacion.thesimpson.feature.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aplicacion.thesimpson.core.error.ErrorApp
import com.aplicacion.thesimpson.feature.domain.Simpson
import com.aplicacion.thesimpson.feature.domain.GetSimpsonsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SimpsonViewModel(
    private val getSimpsonsUseCase: GetSimpsonsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SimpsonListUiState())
    val uiState: StateFlow<SimpsonListUiState> = _uiState.asStateFlow()

    init {
        loadSimpsons()
    }

    fun loadSimpsons() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            val result = getSimpsonsUseCase.execute()

            result.onSuccess { list ->
                _uiState.update { it.copy(isLoading = false, simpsons = list, error = null) }
            }.onFailure { throwable ->
                val appError = (throwable as? ErrorApp) ?: ErrorApp.UnknownError
                _uiState.update { it.copy(isLoading = false, error = appError) }
            }
        }
    }

    data class SimpsonListUiState(
        val isLoading: Boolean = false,
        val simpsons: List<Simpson> = emptyList(),
        val error: ErrorApp? = null
    )
}
