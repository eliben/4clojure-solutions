(ns solutions.166-comparisons)

(def mycomp
  (fn [lessthan x y]
    (cond
      (lessthan x y) :lt
      (lessthan y x) :gt
      :else :eq)))

(mycomp < 5 1)
(mycomp < 1 1)
(mycomp < 1 2)
