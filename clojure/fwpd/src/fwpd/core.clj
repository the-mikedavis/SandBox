(ns fwpd.core)
; the data file
(def filename "suspects.csv")

; the keys for the new maps for the data
(def vamp-keys [:name :glitter-index])

; a conversion function for strings to integers
(defn str->int
  [str]
  (Integer. str))

; the functions used to convert the data type to its mapped value
(def conversions {:name identity
                  :glitter-index str->int})

; the function to take two values and map them to their keys
(defn convert
  "Convert two values from the data into a map."
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  "Filter records by a minimum glitter amount"
  [minimum-glitter records]
  (map :name
    (filter #(>= (:glitter-index %) minimum-glitter) records)))

(defn csv-stringify
  "Converts the map back to a csv string"
  [records]
  (clojure.string/join
    "\n" (map #(clojure.string/join "," %)
              (map #(list (:name %) (:glitter-index %)) records))))

