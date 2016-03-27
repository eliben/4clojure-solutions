(ns solutions.120-squaredigits)

(def digits
  (fn [n]
    (if (= 0 n)
      '()
      (cons (mod n 10)
            (lazy-seq (digits (quot n 10)))))))

(reduce + (map #(* % %) (digits 15)))

(def myssq
  (fn [coll]
    (letfn [(digits [n]
              (if (= 0 n)
                '()
                (cons (mod n 10)
                      (lazy-seq (digits (quot n 10))))))]
      (count (filter identity
                     (map (fn [num] 
                            (< num (reduce + (map #(* % %) (digits num)))))
                          coll))))))

(myssq (range 30))
(filter identity '(true false false true true)) 
