#!/usr/bin/env ng-clj

(require 'clojure.walk)

(defn deep-reverse [lst]
  (clojure.walk/postwalk #(if (seq? %) (reverse %) %) lst))

(def lst (read-string (first *command-line-args*)))

(println (deep-reverse lst))
