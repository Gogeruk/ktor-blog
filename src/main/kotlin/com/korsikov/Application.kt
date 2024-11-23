package com.korsikov

import io.github.cdimascio.dotenv.Dotenv
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.freemarker.FreeMarker
import io.ktor.server.routing.routing
import io.ktor.server.http.content.staticResources
import com.korsikov.controllers.homeController
import freemarker.cache.ClassTemplateLoader
import io.ktor.http.HttpStatusCode
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respondText
import org.slf4j.LoggerFactory

fun Application.module() {
    val log = LoggerFactory.getLogger("Application")
    val dotenv = Dotenv.configure().ignoreIfMissing().load()

    // init environment variables
    val domainUrl = dotenv["DOMAIN_URL"] ?: "FAIL"
    val blogEmail = dotenv["BLOG_EMAIL"] ?: "FAIL"
    val githubUrl = dotenv["GITHUB_URL"] ?: "FAIL"

    // Install FreeMarker templating
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    // Install StatusPages for exception handling
    install(StatusPages) {
        // TODO: fix isDevEnvironment
        exception<Throwable> { call, cause ->
            val env = this@module.environment
//            val isDevEnvironment = env.config.propertyOrNull("ktor.environment")?.getString() == "dev"
            val isDevEnvironment = true

            // create an error message for logging
            val errorMessage = buildString {
                append("An unexpected error occurred:\n")
                append(cause::class.simpleName).append(": ").append(cause.message).append("\n")
                cause.stackTrace?.forEach { append(it.toString()).append("\n") }
            }

            // log the full error details
            log.error("Detailed error information:", cause)

            // respond with a simple error message for the user
            val userMessage = if (isDevEnvironment) {
                // provide full details in dev mode
                errorMessage
            } else {
                // generic message for production
                "An unexpected error occurred. Please try again later."
            }

            call.respondText(
                text = userMessage,
                status = HttpStatusCode.InternalServerError
            )
        }
    }

    // Routing setup
    routing {
        // Serve static resources (CSS, images, etc.)
        staticResources("/static", "static")

        // Home route
        homeController(
            domainUrl = domainUrl,
            blogEmail = blogEmail,
            githubUrl = githubUrl
        )
    }
}