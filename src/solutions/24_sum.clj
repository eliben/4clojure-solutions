(ns solutions.24-sum)

(def mysum
  (fn [coll]
    (reduce + coll)))

(mysum [1 2 3])
(mysum (list 0 -2 5 5))
