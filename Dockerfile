FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY target/comisiones-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8096

ENTRYPOINT ["java", "-jar", "app.jar"]