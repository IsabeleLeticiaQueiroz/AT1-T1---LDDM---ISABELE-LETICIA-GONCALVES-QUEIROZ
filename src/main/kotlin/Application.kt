package com.example

import io.ktor.server.application.*
import com.example.plugins.configureRouting
import com.example.db.migration.seedData
import com.example.plugins.configureSerialization
import org.jetbrains.exposed.sql.Database

fun Application.module() {

    Database.connect(
        url = "jdbc:postgresql://localhost:5432/sylvanian",
        driver = "org.postgresql.Driver",
        user = "admin",
        password = "admin"
    )

    configureSerialization()

    seedData()

    configureRouting()
}