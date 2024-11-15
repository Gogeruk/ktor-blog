package com.korsikov.controllers

import io.ktor.server.application.call
import io.ktor.server.freemarker.FreeMarkerContent
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.homeController(appEnv: String, appSecret: String) {
    get("/") {
        call.respond(
            FreeMarkerContent(
                "base.ftl",
                mapOf(
                    "title" to "Welcome Base Page",
                    "heading" to "Welcome to Ktor with FreeMarker!",
                    "message" to "This is a sample page using FreeMarker templating.",
                    "appEnv" to appEnv,
                    "appSecret" to appSecret
                )
            )
        )
    }
}