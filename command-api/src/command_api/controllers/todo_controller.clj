(ns command-api.controllers.todo-controller
  (:gen-class)
  (:require [compojure.api.sweet :refer [POST PUT]]
            [ring.util.http-response :refer [accepted ok bad-request]]
            [command-api.schemas.todo-schema :refer :all]
            [command-api.services.todo-service :as service]))

(def routes
  [(POST "/todo" []
     :body [model InputTodo]
     :summary "Create a new todo item"
     (let [result (service/new-todo model)]
       (if (true? result)
         (accepted)
         (bad-request))))

   (PUT "/todo/:id" [id]
     :body [model CheckTodo]
     :summary "Change the status of item"
     (let [result (service/check-todo {:id id :check (:check model)})]
       (if (true? result)
         (accepted)
         (bad-request))))])
