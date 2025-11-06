package com.aplicacion.thesimpson.feature.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface SimpsonApiService {
    @GET("characters")
    // Corregido: Debe devolver el objeto wrapper, no la lista
    suspend fun getSimpsons(): Response<SimpsonPaginatedResponse>
}
