(ns solutions.107-closures)

(def npow
  (fn [n]
    (fn [x]
      (reduce * (repeat n x)))))

(def pow4 (npow 4))
(pow4 3)
