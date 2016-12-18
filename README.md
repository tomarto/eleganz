# Eleganz Main

## Command to run the application

Depending on the build you have to do the following:

### JAR

There are two ways to run the application.

To use the development mode you could just run:
- mvn spring-boot:run

For production mode you'd have to run these two commands:
- mvn clean install
- java -jar target/main.jar --spring.profiles.active=prod

### WAR (PENDING)
