(ns command-api.controllers.todo-controller
  (:gen-class)
  (:require [compojure.api.sweet :refer [POST PUT]]
            [ring.util.http-response :refer [accepted ok]]
            [command-api.schemas.todo-schema :refer :all]))

(def routes
  [(POST "/todo" []
     :body [model InputTodo]
     :summary "Create a new todo item"
     (accepted))
   (PUT "/todo/:id" [id]
     :body [model CheckTodo]
     :summary "Change the status of item"
     (accepted))])
