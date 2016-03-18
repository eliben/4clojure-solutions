(ns solutions.44-rotate)

(def s (range 1 6))

(split-at 2 s)
(split-at -2 s)

; handle weird-sized rotates (negative, larger than coll size) by applying mod
(def myrotate
  (fn [n coll]
    (let [realn (mod n (count coll))]
      (concat (drop realn coll) (take realn coll)))))


(myrotate 2 [1 2 3 4 5])
(myrotate -2 [1 2 3 4 5])
(myrotate 6 [1 2 3 4 5])
