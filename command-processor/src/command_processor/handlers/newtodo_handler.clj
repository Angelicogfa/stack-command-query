(ns command-processor.handlers.newtodo-handler
  (:gen-class)
  (:require [clojure.tools.logging :as log]))

(defn handler [event]
  (log/info (str "manipulando evento -> " event)))