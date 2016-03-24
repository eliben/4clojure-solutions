(ns solutions.88-symmdiff)

(def s1 #{1 2 3 4 5 6})
(def s2 #{1 3 5 7})

(clojure.set/difference
 (clojure.set/union s1 s2) (clojure.set/intersection s1 s2))
