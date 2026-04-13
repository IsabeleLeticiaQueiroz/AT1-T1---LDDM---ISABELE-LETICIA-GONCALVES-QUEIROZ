package com.example.repository

import com.example.db.Characters
import com.example.models.Character
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class CharacterRepository {

    fun getAll(): List<Character> = transaction {
        Characters.selectAll().map {
            Character(
                id = it[Characters.id],
                nome = it[Characters.nome],
                familia = it[Characters.familia],
                especie = it[Characters.especie],
                casaId = it[Characters.casaId]
            )
        }
    }

    fun getById(id: Int): Character? = transaction {
        Characters.select { Characters.id eq id }
            .map {
                Character(
                    id = it[Characters.id],
                    nome = it[Characters.nome],
                    familia = it[Characters.familia],
                    especie = it[Characters.especie],
                    casaId = it[Characters.casaId]
                )
            }
            .singleOrNull()
    }

    fun add(character: Character) = transaction {
        Characters.insert {
            it[nome] = character.nome
            it[familia] = character.familia
            it[especie] = character.especie
            it[casaId] = character.casaId
        }
    }

    fun update(id: Int, updated: Character) = transaction {
        Characters.update({ Characters.id eq id }) {
            it[nome] = updated.nome
            it[familia] = updated.familia
            it[especie] = updated.especie
            it[casaId] = updated.casaId
        }
    }

    fun delete(id: Int) = transaction {
        Characters.deleteWhere { Characters.id eq id }
    }
}