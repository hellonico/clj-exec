#!/bin/bash lein-exec

(def fib
  (memoize 
   (fn [x]
       (if (< x 2) 1
       (+' (fib (dec (dec x))) (fib (dec x)))))))

(def i (read-string (second *command-line-args*)))
(prn (last (take i (map fib (iterate inc 0)))))
