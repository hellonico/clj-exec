#!/bin/bash lein-exec

; http://http-kit.org/server.html#options

(use '[leiningen.exec :only  (deps)])
(deps '[[http-kit "2.0.0-RC4"] [compojure "1.1.1"]])

(use 'org.httpkit.server 'org.httpkit.timer
      'compojure.core)

(defn async-handler [request]
 (async-response respond! 
                 (future
                   (respond! "Hello with a latte"))))
          
         
(defn chat-handler [req]
 (when-ws-request req ws-con  ; ws-con bind to the websocket connection
    (on-mesg ws-con (fn [msg]
                        (send-mesg ws-con msg) ;; echo back
                        ; (close-conn ws-con)
                        ))  ;; close the connection
    (on-close ws-con (fn [status] 
        (println ws-con "closed")))))
    
(defn slow-handler [request]
(async-response respond
 (with-timeout respond 10000
   (respond {:status 200 :body "service did not return in 1000ms"})
    (let [result (Thread/sleep 3000)]
     (respond {:status 200 :body "long result"})))))

(defroutes web-handler
 (GET "/" [] {:status 200
    :headers {"Content-Type" "text/html; charset=utf8"}
    :body "hello word from http-kit"})
 (GET "/chat" [] chat-handler)
 (GET "/async" [] async-handler)
 (GET "/slow" [] slow-handler))
 
    
(def port 8090)
(run-server web-handler {:port port})

; wait for 1 year
(println "Server started on port :" port)
(Thread/sleep 31536000)