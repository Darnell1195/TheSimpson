package com.aplicacion.thesimpson.feature.data.remote.api

import com.aplicacion.thesimpson.core.api.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.aplicacion.thesimpson.core.error.ErrorApp
import com.aplicacion.thesimpson.feature.domain.Simpson

class SimpsonsApiRemoteDataSource(private val apiClient: ApiClient) {

    suspend fun getSimpsons(): Result<List<Simpson>> {
        return withContext(Dispatchers.IO) {
            try {
                val apiService = apiClient.createService(SimpsonApiService::class.java)

                val response = apiService.getSimpsons()

                if (response.isSuccessful && response.errorBody() == null) {

                    val body = response.body()


                    val simpsonsList = body?.results ?: emptyList()

                    Result.success(simpsonsList.map { it.toModel() })
                } else {
                    Result.failure(ErrorApp.UnknownError)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Result.failure(ErrorApp.NetworkError)
            }
        }
    }
}