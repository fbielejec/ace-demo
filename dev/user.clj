(ns user
  (:require [figwheel-sidecar.repl-api :refer [start-figwheel! cljs-repl]]))
 
(defn start-figwheel []
  (start-figwheel!)
  (cljs-repl)) 
