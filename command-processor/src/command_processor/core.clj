(ns command-processor.core
  (:gen-class)
  (:require [command-processor.handlers.core :refer [handler]]
            [command-processor.components.kafka.kafka-component :as kafka]
            [clojure.tools.logging :as log]))

(defn -main []
  (println "Iniciando consumer")
  (log/info "Start consumer")
  (kafka/handler handler))