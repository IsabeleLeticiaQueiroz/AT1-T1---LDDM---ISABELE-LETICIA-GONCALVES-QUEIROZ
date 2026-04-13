package com.example.db.migration

import com.example.db.Houses
import com.example.db.Characters
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun seedData() {

    transaction {

        // 🔥 limpa tudo
        SchemaUtils.drop(Characters)
        SchemaUtils.drop(Houses)

        // 🔥 recria tabelas
        SchemaUtils.create(Houses, Characters)

        // 🔥 cria casas e pega os IDs reais
        val casa1Id = Houses.insert {
            it[nome] = "Casa da Família Coelho Chocolate"
            it[localizacao] = "Vila Sylvanian"
        } get Houses.id

        val casa2Id = Houses.insert {
            it[nome] = "Casa da Família Gato Persa"
            it[localizacao] = "Colina Encantada"
        } get Houses.id

        val casa3Id = Houses.insert {
            it[nome] = "Casa da Família Urso Mel"
            it[localizacao] = "Floresta Aconchegante"
        } get Houses.id

        // 🔥 cria personagens usando os IDs corretos
        Characters.insert {
            it[nome] = "Freya Coelho Chocolate"
            it[familia] = "Família Coelho Chocolate"
            it[especie] = "Coelho"
            it[casaId] = casa1Id
        }

        Characters.insert {
            it[nome] = "Coco Coelho Chocolate"
            it[familia] = "Família Coelho Chocolate"
            it[especie] = "Coelho"
            it[casaId] = casa1Id
        }

        Characters.insert {
            it[nome] = "Luna Gata Persa"
            it[familia] = "Família Gato Persa"
            it[especie] = "Gato"
            it[casaId] = casa2Id
        }

        Characters.insert {
            it[nome] = "Milo Urso Mel"
            it[familia] = "Família Urso Mel"
            it[especie] = "Urso"
            it[casaId] = casa3Id
        }
    }
}