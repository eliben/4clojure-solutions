(ns solutions.28-flatten)

; Preliminaries to practice the building blocks for the solution

; Anonymous function with a name (how's that for an oxymoron). Now it can call
; itself!
(def anon-sum
  (fn anon [coll]
    (if (empty? coll)
      0
      (+ (first coll) (anon (rest coll))))))

(anon-sum '(1 2 3 4))

; Mapcat is a nice function. It applies concat to the result of mapping. Useful
; when the mapping returns lists.
(mapcat list [1 2 3] [4 5 6])

; Also useful when mapping over a single collection. Can do one-level
; flattening, though it requires all sub-elements to be sequences too.
(mapcat identity '((1) (2 3) (4 5 6)))

; Now for the solution, mutual recursion between mapcat and our own function
; is just the ticket...

(def myflatten
  (fn doflat [coll]
    (if (sequential? coll)
      (mapcat doflat coll)
      (list coll))))

(myflatten '(1 2 3))
(myflatten '(1 (2) 3))
(myflatten '(1 (2 4) (((3)))))
(myflatten '(1 (2 4) (((3)))))
(myflatten '((1 2) 3 [4 [5 6]]))
