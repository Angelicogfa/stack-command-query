(ns command-api.controllers.core
  (:gen-class)
  (:require [compojure.api.sweet :refer [api context routes]]
            [command-api.controllers.todo-controller :as todo]))

(def swagger-config {:swagger
                     {:ui "/"
                      :spec "/swagger.json"
                      :data {:info {:title "Command API"
                                    :description "API para envio de comandos"}
                             :tags [{:name "todo" :description "Itens a serem executados"}]}}})

(def app
  (api
   swagger-config
   (context "/api" []
     :tags ["todo"]
     (apply routes todo/routes))))