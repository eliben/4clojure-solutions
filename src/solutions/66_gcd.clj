(ns solutions.66-gcd)

(def mygcd
  (fn gcd [a b]
    (if (= 0 b)
      a
      (let [t1 b t2 (mod a b)]
        (gcd t1 t2)))))

(mygcd 4 5)
(mygcd 4 52)


