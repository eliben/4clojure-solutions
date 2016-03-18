(ns solutions.34-range)

; We could do some sort of boring loop, but let's try a cool solution with
; the 'reductions' function.

(reductions (fn [acc v] (inc acc)) -2 '(-2 0 0))

(def myrange
  (fn [start stop]
    (reductions
      (fn [acc v] (inc acc))
      start
      (repeat (- stop start 1) 0))))

(myrange 1 4)
(myrange -2 2)
(myrange 5 8)

; iterate would also work

(take 3 (iterate inc 1))
