(ns solutions.27-palindrome)

; Comparing to reverse is not fun ;-) Let's concoct some loop slicing

(def mypalindrome
  (fn [coll]
    (loop [c coll]
      (if (<= (count c) 1)
        true
        (if (= (first c) (last c))
          (recur (butlast (rest c)))
          false)))))

(mypalindrome '(1))
(mypalindrome '(1 2))
(mypalindrome '(1 2 1))
(mypalindrome '(1 2 2 1))
(mypalindrome '(1 2 3 1))
