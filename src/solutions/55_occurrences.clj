(ns solutions.55-occurrences)

(def s [1 1 2 3 2 1 1])

; using group-by identity to collect all the similar items together.
(group-by identity s)

(def myfreq
  (fn [coll]
    (into {}
     (map (fn [[k v]] {k (count v)}) (group-by identity coll)))))

(myfreq [:b :a :b :a :b])
