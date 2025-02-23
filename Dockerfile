FROM openjdk:17-alpine
VOLUME /tmp
COPY target/monitorsensors-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]