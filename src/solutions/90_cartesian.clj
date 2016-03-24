(ns solutions.90-cartesian)

(defn allcomb
  "All combinations of elements from two sequences sa and sb.
  For (allcomb [1 2] [4 5]) would produce (1 4) (1 5) (2 4) (2 5)."
  [sa sb]
  (if (empty? sa)
    '()
    (concat (partition 2 (interleave (repeat (first sa)) sb))
            (allcomb (rest sa) sb))))

(def mycartesian
  (fn [sa sb]
    (letfn [(allcomb [sa sb]
              (if (empty? sa)
                '()
                (concat (partition 2 (interleave (repeat (first sa)) sb))
                        (allcomb (rest sa) sb))))]
      (set (allcomb sa sb)))))

(set (allcomb #{1 2 3} #{4 5}))
(mycartesian #{1 2 3} #{4 5})
