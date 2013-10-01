#!/usr/bin/env ng-clj

; install nailgun with
; brew install nailgun 

; start the nailgun server with:
; ng-server

; put a file on your classpath named 'ng-clg', with the following content:
; ng clojure.main "$@"

; add clojure to the classpath
; ng ng-cp ~/.m2/repository/org/clojure/clojure/1.5.1/clojure-1.5.1.jar

; running this script will evaluate the following:
(println (+ 1 2))