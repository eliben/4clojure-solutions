(ns solutions.135-infix)

(def myinfix
  (fn [& args]
    (loop [result 0 c (cons + args)]
      (cond (empty? c) result
            (= + (first c))
              (recur (+ result (second c)) (rest (rest c)))
            (= - (first c))
              (recur (- result (second c)) (rest (rest c)))
            (= * (first c))
              (recur (* result (second c)) (rest (rest c)))
            (= / (first c))
              (recur (/ result (second c)) (rest (rest c)))))))

(def myinfix2
  (fn [& args]
    (loop [result 0 c (cons + args)]
      (if (empty? c) 
        result
        (recur (apply (first c) (list result (second c))) (nthrest c 2))))))

(myinfix 2 + 5)
(myinfix 38 + 48 - 2 / 2)
(myinfix2 38 + 48 - 2 / 2)
