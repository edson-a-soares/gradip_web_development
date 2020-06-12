# First stage of the build (compile and build the application)
FROM  maven:3.6.3-openjdk-8 AS MAVEN_BUILD

COPY . application
RUN cd application && mvn clean package -Dmaven.test.skip=true

# its Second stage (copy the application compiled and packed, just to be run)
FROM tomcat:9.0.34-jdk8

ARG artifact_name=gradip-jee-webapp
COPY --from=MAVEN_BUILD application/target/${artifact_name}.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]
