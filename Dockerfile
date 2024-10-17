# Usar una imagen base de Maven para construir la aplicación
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar los archivos del proyecto y compilar la aplicación
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Usar una imagen base de Java para ejecutar la aplicación
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copiar el archivo JAR desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto en el que correrá tu aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]