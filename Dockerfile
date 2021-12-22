FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY src/main/resources/application.properties .
COPY --from=build /home/app/target/*.jar app.jar
EXPOSE 2020
ENTRYPOINT ["java","-jar","/app.jar"]
