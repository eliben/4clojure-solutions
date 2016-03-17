(ns solutions.22-count-sequence)

(def mycount
  (fn [coll]
    (reduce (fn [accum val] (inc accum)) 0 (seq coll))))

(mycount '(1 2 3 4))
(mycount "hello")
