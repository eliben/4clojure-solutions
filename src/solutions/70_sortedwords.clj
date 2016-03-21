(ns solutions.70-sortedwords)

(def s "Clojure, is a fun language!")
(re-seq #"\w+" s)
(sort (re-seq #"\w+" s))

(sort
      #(compare (clojure.string/lower-case %1) (clojure.string/lower-case %2))
  (re-seq #"\w+" s))
