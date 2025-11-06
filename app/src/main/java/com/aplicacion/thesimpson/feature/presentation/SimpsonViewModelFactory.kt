package com.aplicacion.thesimpson.feature.simpson.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aplicacion.thesimpson.core.api.ApiClient
import com.aplicacion.thesimpson.feature.data.remote.api.SimpsonsApiRemoteDataSource
import com.aplicacion.thesimpson.feature.presentation.SimpsonViewModel
import com.aplicacion.thesimpson.feature.data.SimpsonDataRepository
import com.aplicacion.thesimpson.feature.domain.GetSimpsonsUseCase

class SimpsonViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val apiClient = ApiClient()
        val remoteDataSource = SimpsonsApiRemoteDataSource(apiClient)
        val repository = SimpsonDataRepository(remoteDataSource)
        val useCase = GetSimpsonsUseCase(repository)
        return SimpsonViewModel(useCase) as T
    }
}
