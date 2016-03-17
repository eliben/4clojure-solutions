(ns solutions.26-fibonacci)

(def myfib
  (fn [num]
    (reverse
     (reduce (fn [accum val] (cons (+ (first accum) (second accum)) accum))
             '(1 1)
             (range (- num 2))))))

(myfib 6)
(myfib 8)
