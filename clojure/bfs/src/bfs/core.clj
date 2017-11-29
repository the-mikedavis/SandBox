(ns bfs.core
  (:gen-class))

(defn make-vector
  "Make a vector for <m, c, b>"
  [missionaries cannibals boat]
  (hash-map :m missionaries :c cannibals :b boat))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
