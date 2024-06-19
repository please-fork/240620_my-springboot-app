# Use a Gradle image to build the application
FROM gradle:7.6-jdk17 AS build

# Set the working directory
WORKDIR /home/gradle/project

# Copy the project files to the Docker image
COPY . .

# Build the project
RUN gradle build --no-daemon

# Use a slim JDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the previous image
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]