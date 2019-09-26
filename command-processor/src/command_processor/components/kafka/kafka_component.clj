(ns command-processor.components.kafka.kafka-component
  (:gen-class)
  (:require [command-processor.components.kafka.kafka-config :as config])
  (:import [org.apache.kafka.clients.consumer KafkaConsumer ConsumerRecord OffsetAndMetadata]))

(defn- consumer-record->map
  [^ConsumerRecord record]
  {:checksum              (.checksum record)
   :key                   (.key record)
   :offset                (.offset record)
   :partition             (.partition record)
   :serialized-key-size   (.serializedKeySize record)
   :serialized-value-size (.serializedValueSize record)
   :timestamp             (.timestamp record)
   :timestamp-type        (.timestampType record)
   :topic                 (.topic record)
   :value                 (.value record)
   :consumer-record       record})

(defn- commit-message-offset [consumer message]
  (when (and consumer message)
    (let [commit-point (long (inc (.offset ^ConsumerRecord message)))]
      (.commitAsync consumer)
      (println "Mensagem commitada"))))

(defn- process-event [callback consumer record]
  (let [context {:consumer consumer
                 :message (consumer-record->map record)}]
    (try
      (do
        (callback (:message context))
        (commit-message-offset consumer record))
      (catch Exception e (println (.getMessage e))))))

(defn handler [callback]
  (let [config {"bootstrap.servers" config/broker
                "group.id" config/groupid
                "enable.auto.commit" "false"
                "value.deserializer" "org.apache.kafka.common.serialization.StringDeserializer"
                "key.deserializer" "org.apache.kafka.common.serialization.StringDeserializer"}]

    (with-open [consumer (doto (KafkaConsumer. config)
                           (.subscribe [config/topic]))]
      (while true
        (let [^ConsumerRecord records (.poll consumer 1)]
          (doseq [record records]
            (do
              (process-event callback consumer record))))))))