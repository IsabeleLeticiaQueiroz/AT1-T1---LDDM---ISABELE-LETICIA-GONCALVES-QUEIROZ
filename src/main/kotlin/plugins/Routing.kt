package com.example.plugins

import com.example.routes.characterRoutes
import com.example.routes.houseRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.swagger.*

fun Application.configureRouting() {

    routing {

        swaggerUI(
            path = "swagger",
           swaggerFile = "openapi/documentation.yaml"
        )

        characterRoutes()
        houseRoutes()
    }
}