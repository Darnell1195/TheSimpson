package com.aplicacion.thesimpson.feature.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Simpson(
    val id: Int,
    val name: String,
    val occupation: String,
    val portraitPath: String
) : Parcelable