package com.example.routes

import com.example.models.House
import com.example.repository.HouseRepository
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.houseRoutes() {

    val repo = HouseRepository()

    route("/houses") {

        get {
            call.respond(repo.getAll())
        }

        get("/{id}") {
            val id = call.parameters["id"]!!.toInt()
            call.respond(repo.getById(id) ?: "Not found")
        }

        post {
            val house = call.receive<House>()
            repo.add(house)
            call.respond("Created")
        }

        put("/{id}") {
            val id = call.parameters["id"]!!.toInt()
            val updated = call.receive<House>()
            repo.update(id, updated)
            call.respond("Updated")
        }

        delete("/{id}") {
            val id = call.parameters["id"]!!.toInt()
            repo.delete(id)
            call.respond("Deleted")
        }
    }
}