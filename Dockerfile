# ---- Build stage ----
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos primero pom para aprovechar cache
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline

# Copiamos el código y construimos
COPY src ./src
RUN mvn -q -DskipTests package

# ---- Runtime stage ----
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiamos el jar generado
COPY --from=build /app/target/*.jar app.jar

# Puerto por defecto
EXPOSE 8080

# Ejecutar
ENTRYPOINT ["java","-jar","app.jar"]
