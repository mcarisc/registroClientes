# Etapa 1: Build con Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app

# Copiar archivos
COPY pom.xml .
COPY src ./src

# Construir el JAR
RUN mvn clean package -DskipTests

# Etapa 2: Imagen de ejecución
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copiar el JAR desde la etapa de build
COPY --from=builder /app/target/*.jar app.jar

# Puerto expuesto (ajústalo si usas otro)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
