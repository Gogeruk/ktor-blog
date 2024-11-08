


Plauing around with ktor

# to restart application and apply changes
./gradlew clean
./gradlew build
docker-compose up --build

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













