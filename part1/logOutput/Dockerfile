FROM gradle:7.3.3-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM openjdk:11
EXPOSE 8080:8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/strgen-1.0-SNAPSHOT-all.jar /app/logOutput.jar
ENTRYPOINT ["java","-jar","/app/logOutput.jar"]
