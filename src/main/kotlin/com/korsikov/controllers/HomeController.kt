package com.korsikov.controllers

import io.ktor.server.application.call
import io.ktor.server.freemarker.FreeMarkerContent
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.homeController() {
    get("/") {
        call.respond(FreeMarkerContent("home.ftl", mapOf(
            "title" to "Welcome Page",
            "heading" to "Welcome to Ktor with FreeMarker!",
            "message" to "This is a sample page using FreeMarker templating."
        )))
    }
}