# First stage of the build (compile and build the application)
FROM maven:3.6-adoptopenjdk-14 AS MAVEN_BUILD

COPY . application
RUN cd application && mvn clean package


# its Second stage (copy the application compiled and packed, just to be run)
FROM adoptopenjdk/openjdk14

ARG artifact_name=spring-movies-api-1.0.jar
COPY --from=MAVEN_BUILD application/target/spring-movies-api-1.0.jar /usr/local/application/

EXPOSE 8080
WORKDIR /usr/local/application/
CMD ["java", "-jar", "-Dspring.profiles.active=docker",  "spring-movies-api-1.0.jar"]
