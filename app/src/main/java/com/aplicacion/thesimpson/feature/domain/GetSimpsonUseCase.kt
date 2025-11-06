package com.aplicacion.thesimpson.feature.domain

import com.aplicacion.thesimpson.core.error.ErrorApp

class GetSimpsonsUseCase(private val simpsonsRepository: SimpsonsRepository) {
    suspend fun execute(): Result<List<Simpson>> {
        return try {
            simpsonsRepository.getSimpsons()
        } catch (e: Exception) {
            Result.failure(ErrorApp.UnknownError)
        }
    }
}