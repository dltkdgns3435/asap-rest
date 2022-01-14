FROM openjdk:11
EXPOSE 8081
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
COPY /home/ubuntu/spring-config/rest/application.yml /config/rest/application.yml
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/app.jar"]