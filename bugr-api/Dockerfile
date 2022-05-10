FROM gradle:7.4.2-jdk11-alpine as BUILDER
ARG VERSION=0.0.1-SNAPSHOT

COPY . /src
WORKDIR /src
RUN gradle build

FROM openjdk:11.0.8-jre-slim
COPY --from=BUILDER src/build/libs/bugr-api-0.0.1-SNAPSHOT.jar /bin/runner/run.jar
WORKDIR /bin/runner

CMD ["java", "-jar", "run.jar"]