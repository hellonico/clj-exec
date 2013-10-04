#!/usr/bin/env ng-clj

(def lst (read-string (first *command-line-args*)))

(println (vec (map vec (partition-by identity lst))))