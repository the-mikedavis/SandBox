(ns bfs.core
  (:gen-class))

(defn make-vector
  "Make a vector for <m, c, b>"
  [missionaries cannibals boat]
  (hash-map :m missionaries
            :c cannibals
            :b boat))

(def converse-fcns
  (hash-map :m #(- 3 %)
            :c #(- 3 %)
            :b #(- 1 %)))

(defn converse-vector
  [vect]
  (reduce (fn [acc [k v]]
         (assoc acc k ((k converse-fcns) v)))
          {}
          (seq vect)))
         

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
