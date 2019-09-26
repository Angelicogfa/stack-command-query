(ns command-processor.handlers.core
  (:gen-class)
  (:require [cheshire.core :as jsonparser]))

(defn handler [event]
  (let [event-key (:key event)
        event-body (jsonparser/parse-string (:value event) true)]
    (case event-key
      "new-todo-command" (println event-body)
      "check-todo-command" (println event-body))))