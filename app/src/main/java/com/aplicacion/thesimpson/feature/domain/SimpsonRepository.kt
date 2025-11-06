package com.aplicacion.thesimpson.feature.domain

interface SimpsonsRepository {
    suspend fun getSimpsons(): Result<List<Simpson>>
}