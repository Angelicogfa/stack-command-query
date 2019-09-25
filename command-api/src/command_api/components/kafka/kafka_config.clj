(ns command-api.components.kafka.kafka-config
  (:gen-class))

(def broker
  (or (System/getenv "KAFKA_BROKER") "localhost:9092"))

(def topic
  (or (System/getenv "KAFKA_TOPIC") "sample-topic"))