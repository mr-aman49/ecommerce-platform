# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Add a volume for logs
VOLUME /tmp

# Copy the built jar into the container
ARG JAR_FILE=target/auth-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
