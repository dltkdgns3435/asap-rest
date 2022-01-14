FROM openjdk:11
EXPOSE 8081
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
COPY /home/ubuntu/spring-config/rest /config/rest
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/app.jar"]