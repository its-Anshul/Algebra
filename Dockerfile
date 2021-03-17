FROM openjdk:8
MAINTAINER anshul.chauhan
COPY ./target/algebra_services-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","algebra_services-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080