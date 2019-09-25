(ns command-api.schemas.base-schema
  (:gen-class)
  (:require [schema.core :as s :include-macros true]))

(def string-required*
  (complement s/Str))

(defn exist-elements? [element]
  (> (count element) 0))

(defn greater-than-zero? [value]
  (> (Integer/parseInt value) 0))