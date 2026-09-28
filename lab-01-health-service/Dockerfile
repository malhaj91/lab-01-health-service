# Build stage: compile and test using the complete JDK
FROM eclipse-temurin:25-jdk AS build

WORKDIR /workspace

COPY .mvn .mvn
COPY mvnw pom.xml ./

RUN chmod +x mvnw
RUN ./mvnw --batch-mode --no-transfer-progress dependency:go-offline

COPY src src

RUN ./mvnw --batch-mode --no-transfer-progress clean verify


# Runtime stage: run with the smaller JRE
FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=build /workspace/target/*.jar app.jar

# Run as a non-root user for better security
USER 10001:10001

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]