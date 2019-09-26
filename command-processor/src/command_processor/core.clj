(ns command-processor.core
  (:gen-class)
  (:require [command-processor.handlers.core :refer [handler]]
            [command-processor.components.kafka.kafka-component :as kafka]))

(defn -main []
  (println "Iniciando consumer")
  (kafka/handler handler))