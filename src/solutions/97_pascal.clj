(ns solutions.97-pascal)

(def line [1 3 3 1])

(def mypascal
  (fn [n]
    (loop [line [1] i 1]
      (if (= i n)
        line
        (recur 
          (cons 1 (concat (map #(apply + %) (partition 2 1 line)) '(1)))
          (inc i))))))

(map mypascal (range 1 6))
(mypascal 2)

(cons 1 (concat (map #(+ (first %) (second %)) (partition 2 1 line)) '(1)))
(cons 1 (concat (map #(apply + %) (partition 2 1 line)) '(1)))
