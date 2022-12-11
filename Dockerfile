FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/hc-inventory-service.jar
ADD ${JAR_FILE} hc-inventory-service.jar
EXPOSE 5005
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","hc-inventory-service.jar"]
