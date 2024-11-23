package com.korsikov.controllers

import io.ktor.server.application.call
import io.ktor.server.freemarker.FreeMarkerContent
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import kotlin.random.Random

fun Route.homeController(
    domainUrl: String,
    blogEmail: String,
    githubUrl: String
) {
    get("/") {
        val MIN_IMAGE_NUMBER = 1
        val MAX_IMAGE_NUMBER = 135

        val randomImageNumber = Random.nextInt(MIN_IMAGE_NUMBER, MAX_IMAGE_NUMBER + 1)
        val formattedImageNumber = String.format("%03d", randomImageNumber)

        call.respond(
            FreeMarkerContent(
                "home.ftl",
                mapOf(
                    "title" to "Ktor TEST",
                    "domainUrl" to domainUrl,
                    "blogEmail" to blogEmail,
                    "githubUrl" to githubUrl,
                    "random" to formattedImageNumber
                )
            )
        )
    }
}