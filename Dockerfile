# Usar una imagen de Java
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR al contenedor
COPY target/*.jar app.jar

# Exponer el puerto en el que corre la app
EXPOSE 8080

# Comando para ejecutar la aplicación
COPY --chown=root:root target/*.jar app.jar
