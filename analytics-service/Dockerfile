# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the app using only the JAR
FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/target/analytics-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
