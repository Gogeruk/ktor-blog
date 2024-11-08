


Plauing around with ktor

# to restart application and apply changes
./gradlew clean build
docker-compose up -d --build

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













