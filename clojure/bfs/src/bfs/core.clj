(ns bfs.core
  (:gen-class))

(defn make-vector
  "Make a vector for <m, c, b>"
  [missionaries cannibals boat]
  (hash-map :m missionaries
            :c cannibals
            :b boat))

; the conversion functions used to generate a converse vector
(def converse-fcns
  (hash-map :m #(- 3 %)
            :c #(- 3 %)
            :b #(- 1 %)))

(defn converse-vector
  "Generates the converse of a vector"
  [vect]
  (reduce (fn [acc [k v]]
            (assoc acc k ((k converse-fcns) v)))
          {}
          (seq vect)))

(defn- loose-valid?
  "Checks if a vector plays by the rules without checking its converse"
  [vect]
  (not (or (> (:m vect) 3)
           (< (:m vect) 0)
           (> (:c vect) 3)
           (< (:c vect) 0)
           (> (:b vect) 1)
           (< (:b vect) 0)
           (and (> (:m vect) 0)
                (> (:c vect) (:m vect))))))

(defn valid-vector?
  "Checks if a vector plays by the rules"
  [vect]
  (and (loose-valid? vect)
       (loose-valid? (converse-vector vect))))

(defn add-vectors
  "Computes the sum of two vectors"
  [vecta vectb]
  (reduce (fn [acc [k v]]
            (assoc acc k (+ v (k vectb))))
          {}
          vecta))

(defn sub-vectors
  "Computes the subtraction of two vectors"
  [vecta vectb]
  (reduce (fn [acc [k v]]
            (assoc acc k (- v (k vectb))))
          {}
          vecta))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
