package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class House(
    val id: Int? = null,
    val nome: String,
    val localizacao: String
)