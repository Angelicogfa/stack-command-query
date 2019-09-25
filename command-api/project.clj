(defproject command-api "0.0.1"
  :description "API para geração de evento"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [metosin/compojure-api "1.1.12"]
                 [http-kit "2.1.16"]]
  :main command-api.core
  :aot [command-api.core])