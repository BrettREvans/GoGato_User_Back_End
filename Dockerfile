FROM gradle:4.10-jdk8-alpine
RUN gradle build

COPY /build/libs/user-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "app.jar"]