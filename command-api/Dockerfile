FROM clojure:lein AS base
WORKDIR /src/api
COPY . /src/api
RUN lein uberjar

FROM openjdk:8-alpine
COPY --from=base src/api/target/command-api-0.0.1-standalone.jar command-api-0.0.1-standalone.jar
EXPOSE 8080
ENV KAFKA_BROKER=
ENV KAFKA_TOPIC=
CMD ["java", "-jar", "command-api-0.0.1-standalone.jar"]


