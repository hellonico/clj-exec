#!/bin/bash lein-exec

(use '[leiningen.exec :only  (deps)])
(deps '[[clj-todoist "1.0.0"]])
(use '[clj-todoist.core])

(load-file 
	(str 
	 (get (System/getProperties) "user.home")
	 "/.lein/credentials.clj"))
	
(login todoist)
(prn (getProjects {}))