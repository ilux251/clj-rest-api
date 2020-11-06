(ns rest-api.core
  (:require [org.httpkit.server :as server]
            [hiccup.core :as hiccup])
  (:gen-class))

(defn- app 
  [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (hiccup/html [:h1 "API"])})

(defn -main
  "Run the server."
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "4000"))]
    (server/run-server #'app port)
    (println (str "Run server at port " port))))
