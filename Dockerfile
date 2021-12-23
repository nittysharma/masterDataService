FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
COPY src/main/resources/application.properties .
EXPOSE 2020
ENTRYPOINT ["nohup","java","-jar","/app.jar","&"]
