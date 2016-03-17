(ns solutions.23-reverse-sequence)

; cons always produces a list, but 4clojure's tests accept it since '=' compares
; vectors to lists element-wise.
(def myreverse
  (fn [coll]
    (reduce (fn [accum val] (cons val accum)) '() coll)))

(myreverse [1 2 3 4 5])
