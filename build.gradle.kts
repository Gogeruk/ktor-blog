import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application                    // enables application-specific tasks
    kotlin("jvm") version "1.9.10" // kotlin plugin for JVM projects
}

group = "com.korsikov" // my package group
version = "1.0"        // project version

application {
    mainClass.set("io.ktor.server.netty.EngineMain") // "Main" class for Ktor Netty server
}

repositories {
    mavenCentral() // Maven Central repository for dependencies
}

dependencies {
    // core Ktor dependencies
    implementation("io.ktor:ktor-server-core-jvm:2.3.4")
    implementation("io.ktor:ktor-server-netty-jvm:2.3.4")
    implementation("io.ktor:ktor-server-status-pages-jvm:2.3.4")

    // template engine
    implementation("io.ktor:ktor-server-freemarker-jvm:2.3.4")

    // content negotiation
    implementation("io.ktor:ktor-server-content-negotiation:2.3.4")

    // environment variable handling
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")

    // logging
    implementation("ch.qos.logback:logback-classic:1.4.11")

    // database support
    implementation("org.jetbrains.exposed:exposed-core:0.43.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.43.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.43.0")
    implementation("mysql:mysql-connector-java:8.0.33")

    // security
    implementation("io.ktor:ktor-server-auth:2.3.4")
    implementation("io.ktor:ktor-server-auth-jwt:2.3.4")

    // JSON Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    // testing utilities
    testImplementation("io.mockk:mockk:1.13.7")

    // test dependencies
    testImplementation("io.ktor:ktor-server-tests-jvm:2.3.4")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.10")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17" // target JVM version
}