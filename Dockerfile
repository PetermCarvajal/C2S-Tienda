# Etapa 1: Construcción de la aplicación
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa 2: Ejecución de la aplicación
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/TiendaS-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
