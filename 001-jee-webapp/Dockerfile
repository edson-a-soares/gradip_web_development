FROM tomcat:9.0.34-jdk8
ARG artifact_name=gradip-jee-webapp
COPY target/${artifact_name}.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]
