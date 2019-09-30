(ns command-processor.handlers.core
  (:gen-class)
  (:require [cheshire.core :as jsonparser]
            [command-processor.handlers.newtodo-handler :as newtodo]))

(defn handler [event]
  (let [event-key (:key event)
        event-body (jsonparser/parse-string (:value event) true)]
    (case event-key
      "new-todo-command" (newtodo/handler event-body)
      "check-todo-command" (println event-body))))