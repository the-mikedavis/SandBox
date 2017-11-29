(ns bfs.vectors
  (:refer-clojure :exclude [vector]))

(defn make
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

(defn converse
  "Generates the converse of a vector"
  [vector]
  (reduce (fn [acc [k v]]
            (assoc acc k ((k converse-fcns) v)))
          {}
          (seq vector)))

(defn- loose-valid?
  "Checks if a vector plays by the rules without checking its converse"
  [vector]
  (not (or (> (:m vector) 3)
           (< (:m vector) 0)
           (> (:c vector) 3)
           (< (:c vector) 0)
           (> (:b vector) 1)
           (< (:b vector) 0)
           (and (> (:m vector) 0)
                (> (:c vector) (:m vector))))))

(defn valid?
  "Checks if a vector plays by the rules"
  [vector]
  (and (loose-valid? vector)
       (loose-valid? (converse vector))))

(defn add
  "Computes the sum of two vectors"
  [vector-a vector-b]
  (reduce (fn [acc [k v]]
            (assoc acc k (+ v (k vector-b))))
          {}
          vector-a))

(defn sub
  "Computes the subtraction of two vectors"
  [vector-a vector-b]
  (reduce (fn [acc [k v]]
            (assoc acc k (- v (k vector-b))))
          {}
          vector-a))

; also, you can test equality with:
; (= <vector-a> <vector-b>)

; the 5 essential actions:
(def actions
  (list (make 1 0 1)
        (make 2 0 1)
        (make 0 1 1)
        (make 0 2 1)
        (make 1 1 1)))

(defn- add-or-sub
  "Add or subtract depending on the boat position of the first vector"
  [vector-a vector-b]
  (if (= (:b vector-a) 0)
    (add vector-a vector-b)
    (sub vector-a vector-b)))

(defn get-actions
  "Get the possible actions available to a vector"
  [vector]
  (filter valid?
          (reduce (fn [acc v]
                    (conj acc (add-or-sub vector v)))
                  '()
                  actions)))
