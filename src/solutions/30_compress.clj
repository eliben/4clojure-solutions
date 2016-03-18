(ns solutions.30-compress)
(use 'clojure.tools.trace)

; Standard recursion here: we could also do loop...recur, building up the
; resulting sequence in a loop var.
(def mycompress
  (fn f
    ([coll] (f coll nil))
    ([coll prev]
      (if (empty? coll)
        '()
        (if (= (first coll) prev)
           (f (rest coll) prev)
           (cons (first coll) (f (rest coll) (first coll))))))))

(mycompress '(1 1 1 2 3 4 4 5 5 6 6 6))
(mycompress "Leeeeeerrroyyy")
(mycompress [[1 2] [1 2] [3 4] [1 2]])
