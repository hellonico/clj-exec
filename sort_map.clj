#!/usr/bin/env ng-clj

(def lst (read-string (first *command-line-args*)))
(def odr (read-string (second *command-line-args*)))

(defn asort [amap order]
 (conj {} (select-keys amap order)))
 
(println (asort lst odr))
; sort_map.clj "{:a 2 :b 3}" "[:b :a]"
