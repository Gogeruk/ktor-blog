package com.korsikov

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    routing {
        get("/") {
            call.respondText("Hello, Ktor! 3333")
        }
    }
}
