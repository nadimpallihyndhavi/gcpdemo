#FROM openjdk:11-jdk-alpine
#VOLUME /tmp
#COPY target/*.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

#Multistage docker file
FROM maven:3.5.2-jdk-11-alpine AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:11-jre-alpine

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/Springboot-Demo-Project-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090

ENTRYPOINT ["java", "-jar", "app.jar"]