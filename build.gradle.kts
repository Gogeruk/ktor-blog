import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.9.10"
}

group = "com.korsikov"
version = "1.0"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.4")
    implementation("io.ktor:ktor-server-netty:2.3.4")
    implementation("ch.qos.logback:logback-classic:1.4.11")
    testImplementation("io.ktor:ktor-server-tests:2.3.4")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.10")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}