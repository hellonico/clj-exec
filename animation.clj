#!/bin/bash lein-exec

(import 
 '(java.awt Color Graphics Dimension)
 '(java.awt.image BufferedImage)
 '(javax.swing JPanel JFrame))

(def width 900)
(def height 600) 

(defn render
 [g]
 (let [img (new BufferedImage width height 
                 (. BufferedImage TYPE_INT_ARGB))
       bg (. img (getGraphics))]
   (doto bg
      (.setColor (. Color white))
      (.fillRect 0 0 (. img (getWidth)) (. img (getHeight)))
      (.setColor (. Color red))
      (.drawOval 200 200 (rand-int 100) (rand-int 50)))
   (. g (drawImage img 0 0 nil))
   (. bg (dispose))
   ))

(def panel (doto (proxy [JPanel] []
                        (paint [g] (render g)))
             (.setPreferredSize (new Dimension 
                                     width 
                                     height))))

(def frame (doto (new JFrame) (.add panel) .pack .show))

(def animator (agent nil))


(defn animation 
  [x]
  (send-off *agent* #'animation)
  (. panel (repaint))
  (. Thread (sleep 100)))

(send-off animator animation)