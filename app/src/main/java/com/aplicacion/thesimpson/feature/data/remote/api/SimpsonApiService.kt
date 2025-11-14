package com.aplicacion.thesimpson.feature.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface SimpsonApiService {
    @GET("characters")
    suspend fun getSimpsons(): Response<SimpsonPaginatedResponse>
}
