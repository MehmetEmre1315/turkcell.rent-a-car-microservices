FROM openjdk:17-slim as build

COPY target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway-0.0.1-SNAPSHOT.jar
COPY ./src/main/resources/application.properties application.properties
COPY ./src/main/resources/application-docker.properties application-docker.properties

ENTRYPOINT ["java", "-jar", "api-gateway-0.0.1-SNAPSHOT.jar"]