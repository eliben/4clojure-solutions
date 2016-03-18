(ns solutions.43-revinterleave)

(def s (range 10))

; keep-indexed lets us throw away items that don't fulfill some condition and
; the condition takes [index value] as arguments.
(keep-indexed #(when (odd? %1) %2) s)
(keep-indexed #(when (even? %1) %2) s)

; If we map it over the range of partition size...
(println
 (map 
  (fn [n]
    (keep-indexed #(when (= n (mod %1 3)) %2) s))
  (range 3)))

(def myrevinterleave
  (fn [coll ifactor]
    (map
     (fn [n]
       (keep-indexed #(when (= n (mod %1 ifactor)) %2) coll))
     (range ifactor))))

(myrevinterleave [1 2 3 4 5 6] 2)
(myrevinterleave (range 9) 3)
(myrevinterleave (range 10) 5)
