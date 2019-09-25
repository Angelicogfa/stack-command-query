(ns command-api.core
  (:gen-class)
  (:require [command-api.controllers.core :refer [app]]
            [org.httpkit.server :refer [run-server]]))

(defn -main []
  "Ponto de entrada da aplicação - Rode 'lein run'"
  (let [port (Integer/parseInt (or (System/getenv "PORT_API") "80"))]
    (println (str "Start app in port " port))
    (run-server app {:port port})))