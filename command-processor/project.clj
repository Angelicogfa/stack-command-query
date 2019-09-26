(defproject command-processor "0.0.1"
  :description "API para consumir eventos do kafka"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.apache.kafka/kafka-clients "1.1.0"]
                 [cheshire "5.9.0"]]
  :main command-processor.core)