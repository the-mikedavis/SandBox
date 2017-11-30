(ns bfs.core
  (:require [bfs.vectors :as vectors])
  (:gen-class))

(defn ^:dynamic solve
  [vect]
  (println "Starting the solver at the specified vector")
  (loop [queue [vect]
         iteration 0]
    (if (vectors/goal? (first queue))
      {:node (first queue) :iter iteration}
      (let [[part & remaining] queue]
        (recur (into remaining (vectors/get-actions part))
               (inc iteration))))))

(defn -main
  [& args]
  (let [solution (solve (vectors/make 3 3 1))]
    (println (str "It took this path:\n"
                  (vectors/stringify-path (:node solution))
                  "\nIterations: "
                  (:iter solution)))))
