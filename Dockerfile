FROM openjdk:8-jdk-alpine
ADD build/libs/simple-todo-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENV SPRING_DATA_MONGODB_HOST mongo
ENTRYPOINT ["java", "-jar", "/app.jar"]
