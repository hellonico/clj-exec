#!/usr/bin/env lein-exec

; convert a PDF to images
; see http://pdfbox.apache.org/userguide/cookbook.html

(leiningen.exec/deps '[[org.apache.pdfbox/pdfbox "1.4.0"]])
(org.apache.pdfbox.PDFToImage/main 
  (into-array String (rest *command-line-args*)))