package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val id: Int? = null,
    val nome: String,
    val familia: String,
    val especie: String,
    val casaId: Int
)