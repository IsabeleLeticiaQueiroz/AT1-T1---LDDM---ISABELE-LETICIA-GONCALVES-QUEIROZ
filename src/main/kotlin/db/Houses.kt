package com.example.db

import org.jetbrains.exposed.sql.Table

object Houses : Table() {

    val id = integer("id").autoIncrement()
    val nome = varchar("nome", 100)
    val localizacao = varchar("localizacao", 100)

    override val primaryKey = PrimaryKey(id)
}