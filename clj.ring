#!/bin/bash lein-exec
(use '[leiningen.exec :only  (deps)])
(deps '[[ring "1.2.0-beta1"]])

(defn handler
  [request]
  {:status 200
   :headers {"content-type" "application/json"}
   :body (str request)})

(use 'ring.middleware.file)
(def app
 (wrap-file handler "."))

(use 'ring.adapter.jetty)
(run-jetty app {:port 3000})