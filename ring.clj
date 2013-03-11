#!/bin/bash lein-exec

(use '[leiningen.exec :only  (deps)])
(deps '[[ring "1.2.0-beta1"]])
(use 'ring.middleware.resource
     'ring.middleware.file-info)
(use 'ring.adapter.jetty)

(defn handler [request]
{:status 200
 :headers {"Content-Type" "text/plain"}
 :body "Hello World"})

(def app
 (-> handler
     (wrap-resource ".")
     (wrap-file-info)))

(run-jetty app {:port 3000})