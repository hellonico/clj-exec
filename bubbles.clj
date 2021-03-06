#!/bin/bash lein-exec

(set! *unchecked-math* true)
(set! *warn-on-reflection* true)

(defn swap [^longs a ^long i ^long j]
  (let [t (aget a i)]
    (aset a i (aget a j))
    (aset a j t)))

(defn ^long apartition [^longs a ^long pivot ^long i ^long j]
  (loop [i i j j]
    (if (<= i j)
      (let [v (aget a i)]
        (if (< v pivot)
          (recur (inc i) j)
          (do 
            (when (< i j) 
              (aset a i (aget a j))
              (aset a j v))
            (recur i (dec j)))))
      i)))

(defn qsort 
  ([^longs a]
     (qsort a 0 (long (alength a))))
  ([^longs a ^long lo ^long hi]    
     (when
         (< (inc lo) hi)
       (let [pivot (aget a lo)
             split (dec (apartition a pivot (inc lo) (dec hi)))]
         (when (> split lo)
           (swap a lo split))
         (qsort a lo split)
         (qsort a (inc split) hi)))
     a))

(defn ^longs rand-long-array [i]
  (let [rnd (java.util.Random.)] 
    (long-array (repeatedly i #(.nextLong rnd)))))

(use 'clojure.pprint)

(def i (read-string (second *command-line-args*)))
(def as (rand-long-array i))
(qsort as)
; (pprint (qsort as))
; (java.util.Arrays/sort as)
; (pprint as)

; (comment
;   (dotimes [_ 10]
;     (let [as (rand-long-array)]
;       (time
;        (dotimes [_ 1] 
;          (qsort as)))))
;   )