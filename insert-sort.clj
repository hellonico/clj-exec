#!/usr/bin/env ng-clj

(defn my-insert [n lst]
  (cond 
    (empty? lst) (list n)
    (> (first lst) n) (conj lst n)
    :else (conj (my-insert n (rest lst)) (first lst))))

(defn my-insertion-sort [lst]
  (loop [list lst result '()]
    (if (empty? list) result
        (recur (rest list) (my-insert (first list) result)))))

(def lst (read-string (first *command-line-args*)))

(println (my-insertion-sort lst))