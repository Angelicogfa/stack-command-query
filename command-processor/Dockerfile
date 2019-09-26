FROM clojure:lein AS base
WORKDIR /src/api
COPY . /src/api
RUN lein uberjar

FROM clojure:lein
COPY --from=base src/api/target/command-processor-0.0.1-standalone.jar command-processor-0.0.1-standalone.jar
EXPOSE 8080
ENV KAFKA_BROKER=
ENV KAFKA_TOPIC=
ENV KAFKA_GROUPID=
CMD ["java", "-jar", "command-processor-0.0.1-standalone.jar"]


