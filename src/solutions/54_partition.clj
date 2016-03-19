(ns solutions.54-partition)

(def s (range 8))

; map-indexed to create a sequence of (index value) from original sequence
(map-indexed #(list %1 %2) s)

(def mypartition
  (fn [n coll]
    (filter #(= (count %) n)
            ; use reductions to combine subsequent sub-lists as long as some
            ; condition applies and have the intermediate lists available
            (reductions
             (fn [acc val] (if (= 0 (mod (first val) n))
                             (rest val)
                             (concat acc (rest val))))
             '()
             (map-indexed #(list %1 %2) coll)))))

(mypartition 3 (range 8))
