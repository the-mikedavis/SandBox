(ns implementations)

(defn my-comp
  "My implementation of the comp function"
  [& functions]
  (fn [& arguments]
    (reduce (fn [arg fun] (fun arg))
            (apply (last functions) arguments)
            (rest reverse functions))))
