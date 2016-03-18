(ns solutions.33-replicate)

; repeat lets us repeat whatever any number of times
(repeat 3 '(1 2 3))

; Then we can interleave all these sequences by means of apply
(apply interleave (repeat 3 '(1 2 3)))

(def myreplicate
  #(apply interleave (repeat %2 %1)))

; Seems like the server of 4clojure has a version of interleave that won't
; accept just a single argument, so work around that...
(def myreplicate2
  (fn [coll n]
    (if (= n 1)
      coll
      (apply interleave (repeat n coll)))))



(myreplicate [1 2 3] 2)
(myreplicate [1 2 3] 1)
(myreplicate2 [1 2 3] 1)
