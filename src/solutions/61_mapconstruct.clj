(ns solutions.61-mapconstruct)

; Converting a list of key/value pairs to a map
(into {} [[:a 1] [:b 2]])

; And from a list of alternating keys/values
(apply hash-map [:a 1 :b 2])

; Interleave to zip two lists:
(interleave [:a :b :c] [1 2 3])

; ... and together
(apply hash-map (interleave [:a :b :c] [1 2 3]))

(def myc
  (fn
    [lst1 lst2]
    (apply hash-map (interleave lst1 lst2))))

(myc [:a :b :c] [1 2 3])
