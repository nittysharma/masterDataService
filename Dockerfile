FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
VOLUME /tmp
COPY src/main/resources/application.properties .
COPY target/*.jar app.jar
EXPOSE 2020
ENTRYPOINT ["java","-jar","/app.jar"]
