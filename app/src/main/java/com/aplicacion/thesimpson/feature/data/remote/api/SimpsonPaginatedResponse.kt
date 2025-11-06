package com.aplicacion.thesimpson.feature.data.remote.api

import com.google.gson.annotations.SerializedName

data class SimpsonPaginatedResponse(

    @SerializedName("results")
    val results: List<SimpsonApiModel>
)