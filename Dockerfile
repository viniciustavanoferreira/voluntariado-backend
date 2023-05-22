#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package

#
# Package stage
#
FROM openjdk:17-alpine
COPY --from=build /target/microservice-0.0.1-SNAPSHOT.jar microservice.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","microservice.jar"]