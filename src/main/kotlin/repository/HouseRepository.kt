package com.example.repository

import com.example.db.Houses
import com.example.models.House
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class HouseRepository {

    fun getAll(): List<House> = transaction {
        Houses.selectAll().map {
            House(
                id = it[Houses.id],
                nome = it[Houses.nome],
                localizacao = it[Houses.localizacao]
            )
        }
    }

    fun getById(id: Int): House? = transaction {
        Houses.select { Houses.id eq id }
            .map {
                House(
                    id = it[Houses.id],
                    nome = it[Houses.nome],
                    localizacao = it[Houses.localizacao]
                )
            }
            .singleOrNull()
    }

    fun add(house: House) = transaction {
        Houses.insert {
            it[nome] = house.nome
            it[localizacao] = house.localizacao
        }
    }

    fun update(id: Int, updated: House) = transaction {
        Houses.update({ Houses.id eq id }) {
            it[nome] = updated.nome
            it[localizacao] = updated.localizacao
        }
    }

    fun delete(id: Int) = transaction {
        Houses.deleteWhere { Houses.id eq id }
    }
}