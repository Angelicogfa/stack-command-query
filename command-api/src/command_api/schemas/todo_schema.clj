(ns command-api.schemas.todo-schema
  (:gen-class)
  (:require [schema.core :as s :include-macros true]
            [command-api.schemas.base-schema :refer :all]))

(s/defschema InputTodo
  {:description (s/constrained s/Str exist-elements? "Description is required")})

(s/defschema CheckTodo
  {:check s/Bool})