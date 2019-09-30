(defproject command-processor "0.0.1"
  :description "API para consumir eventos do kafka"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.apache.kafka/kafka-clients "1.1.0"]
                 [cheshire "5.9.0"]
;;                 [com.taoensso/timbre "4.10.0"]
                 [org.clojure/tools.logging "0.5.0"]
                 [org.slf4j/slf4j-log4j12 "1.7.25"]
                 [net.logstash.logback/logstash-logback-encoder "5.0"]]
  :main command-processor.core)