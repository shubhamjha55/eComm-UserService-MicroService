FROM openjdk:17
WORKDIR /app
COPY ./target/user-service-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar"]