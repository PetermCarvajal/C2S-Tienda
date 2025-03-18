FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Debug: Listar archivos en target antes de copiar
RUN ls -lh target/

# Copiar el archivo JAR
COPY target/*.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Ejecutar la app
CMD ["java", "-jar", "app.jar"]
