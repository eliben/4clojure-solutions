(ns solutions.143-dot)

(def s1 [1 2 3])
(def s2 [4 5 6])

(def mydot
  (fn [sa sb]
    (apply + (map * sa sb))))

(mydot s1 s2)
