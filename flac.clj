#!/bin/bash lein-exec

(use '[leiningen.exec :only  (deps)])
(deps '[[jflac/jflac-examples "1.4.0-SNAPSHOT"]])

(def file (second *command-line-args*))
(org.kc7bfi.jflac.apps/main [file])