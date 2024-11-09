package com.korsikov

import com.korsikov.controllers.homeController
import freemarker.cache.ClassTemplateLoader
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.freemarker.FreeMarker
import io.ktor.server.routing.routing
import io.ktor.server.http.content.staticResources

fun Application.module() {

    // install the FreeMarker plugin for templating
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    // configure routing
    routing {
        // configure static files routing
        // maps /static path to resources/static folder
        staticResources("/static", "static")

        // register controllers
        homeController()
    }
}