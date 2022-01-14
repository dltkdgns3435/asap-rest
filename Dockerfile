FROM openjdk:11
EXPOSE 8081
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
COPY copy.yml /config/rest/application.yml
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/app.jar"]