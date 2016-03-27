(ns solutions.118-map)

(def mymap
  (fn mm_ [f coll]
    (if (seq coll)
      (cons (f (first coll)) (lazy-seq (mm_ f (rest coll))))
      '())))

(mymap inc '(1 2 3))
(mymap inc [1 2 3])

(mymap (fn [_] nil) (range 10))
