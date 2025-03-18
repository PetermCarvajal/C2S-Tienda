# Usa una imagen de Java adecuada
FROM eclipse-temurin:17-jdk AS build

# Define el directorio de trabajo
WORKDIR /app

# Copiar el .jar si existe
COPY target/*.jar app.jar

# Exponer el puerto de la app
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
