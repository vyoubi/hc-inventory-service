FROM adoptopenjdk/openjdk11
VOLUME /tmp
ARG JAR_FILE=build/libs/hc-inventory-service.jar
ADD ${JAR_FILE} hc-inventory-service.jar
EXPOSE 5005
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","hc-inventory-service.jar"]
