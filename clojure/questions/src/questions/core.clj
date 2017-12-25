(ns questions.core
  (:require [clojure.string :as string])
  (:gen-class))

(def filename "questions.txt")

(defn read-questions
  [filename]
  (-> filename
      slurp
      (string/split #"\n")
      seq))

(defn rand-index
  "Get a random index within the size of the collection. More specifically
  returns a pseudorandom integer between 0 and n, where n is the size of
  the collection"
  [coll]
  (-> coll count rand int))

(defn drop-nth
  "Drop the nth indexed element in a seq. Returns the collection less
  the element at that index."
  [coll index]
  (keep-indexed #(if (not= %1 index) %2) coll))

(defn cut-rand-elem
  "Find a random index and cut out that element, returning a list with
  the first element as the cut out element and the second as the list
  without that element"
  [coll]
  (let [index (rand-index coll)]
    (list (nth coll index) (drop-nth coll index))))

(defn ask-question
  [question]
  (println question)
  (read-line))

(defn -main
  "Read through the questions and exit when complete"
  []
  (println "Starting question battery."
  (loop [question-coll (read-questions filename)]
    (if (empty? question-coll)
      (-main) ; start all over again when done
      (let [split (cut-rand-elem question-coll)
            question (first split)
            remain (second split)]
        (ask-question question)
        (recur remain))))))
