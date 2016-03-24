(ns solutions.81-intersect)

(def s #{0 1 2 3})

(get s 9)
(conj s 19)

(def myintersect
  (fn [s1 s2]
    (reduce conj
            #{}
            (filter #(contains? s2 %) s1))))

(myintersect #{0 1 2 9} #{4 1 9 3})
