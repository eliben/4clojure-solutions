(ns solutions.80-perfect-numbers)

(def isperfect
  (fn [num]
(letfn [(divisors
  [n]
  (loop [i 1
         divs []]
    (if (> (* i 2) n)
      divs
      (if (= 0 (mod n i))
        (recur (+ i 1) (conj divs i))
        (recur (+ i 1) divs)))))]
  (= (reduce + (divisors num)) num))))


(divisors 6)
(divisors 20)
    
