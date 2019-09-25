FROM clojure:lein AS base
WORKDIR /src/api
COPY . /src/api
RUN lein uberjar

FROM clojure:lein
COPY --from=base src/api/target/command-api-0.0.1-standalone.jar command-api-0.0.1-standalone.jar
ENV PORT_API=
EXPOSE 8080
CMD ["java", "-jar", "command-api-0.0.1-standalone.jar"]