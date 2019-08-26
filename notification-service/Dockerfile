FROM openjdk:11-jre

ADD ./target/notification-service-1.0.0.jar  notification-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","notification-service.jar"]
