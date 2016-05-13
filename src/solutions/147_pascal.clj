(ns solutions.147-pascal)

(defn onerep
  [arr]
  (map + (into [0] arr) (conj arr 0)))

(vec (onerep [1 1]))


(def pascal
  (fn pascal
    ([init]
     (letfn [(onerep [arr]
               (map +' (into [0] arr) (conj arr 0)))]
       (lazy-seq
        (cons init (pascal (vec (onerep init)))))))))

(take 5 (pascal [1]))
