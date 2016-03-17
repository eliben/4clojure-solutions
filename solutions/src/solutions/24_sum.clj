(ns solutions.24-sum)

(def mysum
  (fn [coll]
    (reduce + coll)))

(mysum [1 2 3])
