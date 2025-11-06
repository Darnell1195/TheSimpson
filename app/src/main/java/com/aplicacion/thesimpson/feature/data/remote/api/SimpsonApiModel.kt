package com.aplicacion.thesimpson.feature.data.remote.api

data class SimpsonApiModel (
    val id: Int = 0, // Corregido: Es un Int en el JSON
    val name: String,
    val occupation: String,
    val portrait_path: String
)