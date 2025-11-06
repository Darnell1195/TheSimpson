package com.aplicacion.thesimpson.feature.data

import com.aplicacion.thesimpson.feature.data.remote.api.SimpsonsApiRemoteDataSource
import com.aplicacion.thesimpson.feature.domain.Simpson
import com.aplicacion.thesimpson.feature.domain.SimpsonsRepository

class SimpsonDataRepository (
    private val remoteDataSource: SimpsonsApiRemoteDataSource
) : SimpsonsRepository {
    override suspend fun getSimpsons(): Result<List<Simpson>> {
        return remoteDataSource.getSimpsons()
    }
}