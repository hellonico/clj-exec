#!/bin/bash lein-exec

(import 
	'javax.imageio.ImageIO
    'java.awt.image.BufferedImage)
(require '[clojure.java.io :only [as-file input-stream output-stream] :as io])

(defn make-thumbnail-generic 
  [input new-filename width]
  	(let [
  		fi (io/as-file input)
  		fo (io/as-file new-filename)
  	    img (ImageIO/read fi)
  	    ext (second (re-find #"\.(.*)" (.getName fo)))
        imgtype (BufferedImage/TYPE_INT_ARGB)
        width (min (.getWidth img) width)
        height (* (/ width (.getWidth img)) (.getHeight img))
        simg (BufferedImage. width height imgtype)
        g (.createGraphics simg)]
    (.drawImage g img 0 0 width height nil)
    (.dispose g)
    (ImageIO/write simg ext fo)
    ))

(defn make-thumbnail-from-file [filename new-filename width]
  (make-thumbnail-generic filename new-filename width))

(def input (nth *command-line-args* 1))
(def output (nth *command-line-args* 2))
(def size (nth *command-line-args* 3))

(make-thumbnail-from-file input output (Integer/parseInt size))