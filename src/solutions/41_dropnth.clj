(ns solutions.41-dropnth)

(def s [1 2 3 4 5 6 7 8])

; Using partition-all to split a sequence into chunks of size 'n'
(partition-all 3 s)

(mapcat #(if (= (count %) 3) (butlast %) %) (partition-all 3 s))

(def mydropnth
  (fn [coll n]
    (mapcat #(if (= (count %) n)
               (butlast %)
               %)
            (partition-all n coll))))

(mydropnth s 3)
(mydropnth s 5)
