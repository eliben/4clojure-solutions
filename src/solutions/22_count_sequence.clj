(ns solutions.22-count-sequence)

; Using 'seq' inside to cast all kinds of collections (like strings) into
; sequences.
(def mycount
  (fn [coll]
    (reduce (fn [accum val] (inc accum)) 0 (seq coll))))

(mycount '(1 2 3 4))
(mycount "hello")
