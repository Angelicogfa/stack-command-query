(ns command-api.components.kafka.kafka-component
  (:gen-class)
  (:require [cheshire.core :as jsonparser]
            [command-api.components.kafka.kafka-config :as config])
  (:import [org.apache.kafka.clients.producer KafkaProducer ProducerRecord]))

(defn send-data! [key-event body-event]
  (let [config {"value.serializer" "org.apache.kafka.common.serialization.StringSerializer"
                "key.serializer" "org.apache.kafka.common.serialization.StringSerializer"
                "bootstrap.servers" config/broker
                "acks" "all"}]

    (with-open [producer (KafkaProducer. config)]
      (->> (jsonparser/generate-string  body-event)
           (ProducerRecord. config/topic key-event)
           (.send producer)
           (.get)
           (println "Evento processado -> ")))))