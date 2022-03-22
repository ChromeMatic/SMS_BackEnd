FROM openjdk:17
EXPOSE 8080
ADD target/sms-docker.jar sms-docker.jar
ENTRYPOINT ["java","-jar","/sms-docker.jar","--spring.config.additional-location=application.properties"]