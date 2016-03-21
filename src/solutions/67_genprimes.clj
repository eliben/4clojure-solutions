(ns solutions.67-genprimes)

; Mapping keywords to vectors
(def m {:a [1 2 3] :t [2]})

; get with default []
(get m :a [])
(get m :c [])

; Let's see how to do a-la Python's setdefault to update such mappings nicely
(update m :a #(if (nil? %) [4] (conj % 4)))
(update m :c #(if (nil? %) [4] (conj % 4)))

(merge-with (comp vec concat) m {:a [7 9] :d [5]})

(into {} (map #(vector % (inc %)) [1 2 3 4]))

; Implements the approach outlined in http://stackoverflow.com/a/568618/8206
(def mygenprimes
  (fn [x]
    (loop [pcoll [] d {} q 2]
      ; pcoll: collection of primes we're putting together
      ; d: maps composites to primes witnessing their compositeness
      ; q: integer that's checked for primeness in each iteration
      ;(println pcoll d q)
      (if (>= (count pcoll) x)
        pcoll
        (if (contains? d q)
          (let [qvals (get d q [])]
            (recur pcoll
                   (dissoc 
                    (merge-with (comp vec concat)
                                d
                                (into {}
                                      (map #(vector (+ q %) (vector %)) qvals)))
                    q)
                   (inc q)))
          (recur (conj pcoll q)
                 (assoc d (* q q) [q])
                 (inc q)))))))

(mygenprimes 100)
