# ===========================
# Stage 1: Build the Spring Boot JAR
# ===========================
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build

# Set working directory
WORKDIR /app

# Copy only pom.xml first for faster dependency resolution
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the project and skip tests
RUN mvn clean package -DskipTests

# ===========================
# Stage 2: Run the Spring Boot app
# ===========================
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR from build stage
COPY --from=build /app/target/anurag-portfolio-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render sets PORT dynamically)
EXPOSE 8080

# Set entrypoint to run Spring Boot
ENTRYPOINT ["java","-jar","/app/app.jar"]
