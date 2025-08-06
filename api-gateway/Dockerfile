# Use official Gradle image with JDK 17
FROM gradle:8.5-jdk17-alpine AS build

WORKDIR /app

# Copy everything first
COPY . /app

# Make gradlew executable
RUN chmod +x gradlew

# Build the Spring Boot JAR
RUN ./gradlew bootJar --no-daemon

# Runtime image
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
