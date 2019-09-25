(ns command-api.core
  (:gen-class)
  (:require [command-api.controllers.core :refer [app]]
            [org.httpkit.server :refer [run-server]]))

(defn -main []
  "Ponto de entrada da aplicação - Rode 'lein run'"
    (println (str "Start app in port " 8080))
    (run-server app {:port 8080}))