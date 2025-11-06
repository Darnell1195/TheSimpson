package com.aplicacion.thesimpson.core.error

sealed class ErrorApp : Throwable() {
    object NetworkError : ErrorApp()
    object NotFoundError : ErrorApp()
    object UnknownError : ErrorApp()
}