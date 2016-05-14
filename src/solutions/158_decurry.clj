(ns solutions.158-decurry)

(def cf
  (fn [a]
    (fn [b]
      (fn [c]
        (fn [d]
          (+ a b c d))))))

((((cf 2) 3) 4) 5)

(def decurry
  (fn [f]
    (fn [& args]
      (loop [ar args
             func-to-call f]
        (if (empty? ar)
          func-to-call
          (let [nextret (func-to-call (first ar))]
            (recur (rest ar) nextret)))))))

(def df (decurry cf))
(df 2 3 4 5)
