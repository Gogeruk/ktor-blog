Playing around with ktor and kotlin!
Playing around with ktor and kotlin!
Playing around with ktor and kotlin!

# to restart application and apply changes
./gradlew clean build --refresh-dependencies
docker-compose up -d --build

# debuting
./gradlew run --stacktrace
./gradlew run --stacktrace --info


# for dev
# in application.conf do:
``````
    deployment {
        // ...
        development = true
    }
```
# and then: 
docker-compose up --build













