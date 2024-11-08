# Stage 1: Build the application
FROM gradle:8.3-jdk17 AS build

WORKDIR /app

COPY build.gradle.kts settings.gradle.kts /app/
COPY src /app/src

RUN gradle clean installDist

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/build/install/ktor-blog /app/

EXPOSE 8080

ENTRYPOINT ["./bin/ktor-blog"]