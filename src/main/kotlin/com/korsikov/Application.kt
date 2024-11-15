package com.korsikov

import io.github.cdimascio.dotenv.Dotenv
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.freemarker.FreeMarker
import io.ktor.server.routing.routing
import io.ktor.server.http.content.staticResources
import com.korsikov.controllers.homeController
import freemarker.cache.ClassTemplateLoader

fun Application.module() {
    // load environment variables
    val dotenv = Dotenv.configure().ignoreIfMissing().load()

    // install the FreeMarker plugin
    install(FreeMarker) {
        this.templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    // configure routing
    routing {
        staticResources("/static", "static")
        homeController(dotenv["APP_ENV"], dotenv["APP_SECRET"])
    }
}