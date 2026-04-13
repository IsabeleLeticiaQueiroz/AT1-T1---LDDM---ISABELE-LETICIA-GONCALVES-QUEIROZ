package com.example.routes

import com.example.models.Character
import com.example.repository.CharacterRepository
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.characterRoutes() {

    val repo = CharacterRepository()

    route("/characters") {

        // GET ALL
        get {
            call.respond(repo.getAll())
        }

        // GET BY ID
        get("/{id}") {
            val id = call.parameters["id"]!!.toInt()
            val character = repo.getById(id)
            if (character != null)
                call.respond(character)
            else
                call.respond("Not found")
        }

        // POST
        post {
            val character = call.receive<Character>()
            repo.add(character)
            call.respond("Created")
        }

        // PUT
        put("/{id}") {
            val id = call.parameters["id"]!!.toInt()
            val updated = call.receive<Character>()
            repo.update(id, updated)
            call.respond("Updated")
        }

        // DELETE
        delete("/{id}") {
            val id = call.parameters["id"]!!.toInt()
            repo.delete(id)
            call.respond("Deleted")
        }
    }
}