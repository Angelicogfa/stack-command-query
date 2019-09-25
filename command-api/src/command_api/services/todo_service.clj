(ns command-api.services.todo-service
  (:gen-class)
  (:require [command-api.components.kafka.kafka-component :refer [send-data!]]))

(defn new-todo [{description :description}]
  (let [event {:description description}]
    (try
      (do
        (send-data! "new-todo-command" event)
        true)
      (catch Exception e
        (println (.getMessage e))))))

(defn check-todo [{id :id check :check}]
  (let [event {:id id :check check}]
    (try
      (do
        (send-data! "check-todo-command" event)
        true)
      (catch Exception e
        (println (.getMessage e))))))
