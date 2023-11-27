FROM openjdk:17-slim as build

COPY target/rental-service-0.0.1-SNAPSHOT.jar rental-service-0.0.1-SNAPSHOT.jar
COPY ./src/main/resources/application.properties application.properties
COPY ./src/main/resources/application-docker.properties application-docker.properties

ENTRYPOINT ["java", "-jar", "rental-service-0.0.1-SNAPSHOT.jar"]