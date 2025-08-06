# Use an official OpenJDK image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Set JAVA_OPTS environment variable
ENV JAVA_OPTS="-Xms512M -Xmx512M"

# Expose the port that the application uses
EXPOSE 8080

# Set permissions
RUN chmod +x /app/build/libs/api-gateway-0.0.1-SNAPSHOT.jar

# Run the application
CMD ["java", "-jar", "/app/build/libs/api-gateway-0.0.1-SNAPSHOT.jar"]