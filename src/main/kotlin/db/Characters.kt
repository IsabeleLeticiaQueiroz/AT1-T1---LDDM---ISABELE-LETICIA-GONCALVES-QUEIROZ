package com.example.db

import org.jetbrains.exposed.sql.Table


object Characters : Table() {
    val id = integer("id").autoIncrement()
    val nome = varchar("nome", 100)
    val familia = varchar("familia", 100)
    val especie = varchar("especie", 50)
    val casaId = integer("casaId")

    override val primaryKey = PrimaryKey(id)
}