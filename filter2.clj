#!/usr/bin/env ng-clj

(defn filter* [f map]
  (reduce (fn [m [k v :as x]]
            (if-not (f x)
              (dissoc m k)
              m))
          map map))
                    
(def lst (read-string (first *command-line-args*)))

(println (filter* #(-> % val (= 1)) lst))

; filter2.clj "{:a 1 :b 1 :c 2 :d 7 :e 1} "