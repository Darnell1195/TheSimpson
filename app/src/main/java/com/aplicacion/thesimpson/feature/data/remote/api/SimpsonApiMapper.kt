package com.aplicacion.thesimpson.feature.data.remote.api

import com.aplicacion.thesimpson.feature.domain.Simpson

fun SimpsonApiModel.toModel(): Simpson {


    val fullImageUrl = "https://cdn.thesimpsonsapi.com/500${portrait_path}"

    return Simpson(
        id = id,
        name = name,
        occupation = occupation,
        portraitPath = fullImageUrl,
    )
}
