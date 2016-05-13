(ns solutions.153-pairwise-disjoint-sets)

(def s1 #{1 2 3 4})
(def s2 #{5 6})
(def s3 #{4 5})

; Intersection between two sets
(clojure.set/intersection s1 s3)

(def ss #{s1 s2 s3})

(for [x ss
      y ss]
  (list x y))
  ;(clojure.set/intersection x y))

; all pairs of items from coll
(defn all-pairs [coll]
  (when-let [s (next coll)]
    (lazy-cat (for [y s] [(first coll) y])
              (all-pairs s))))

(def ss2 #{s1 s2})
(def intersects 
  (map #(clojure.set/intersection (first %) (second %)) (all-pairs ss2)))

(not-any? not-empty intersects)

(def alldisjoint
  (fn [ss]
    (letfn [(all-pairs [coll]
              (when-let [s (next coll)]
                (lazy-cat (for [y s] [(first coll) y])
                          (all-pairs s))))]
      (not-any?
       not-empty
       (map #(clojure.set/intersection (first %) (second %)) (all-pairs ss))))))

(alldisjoint ss)
