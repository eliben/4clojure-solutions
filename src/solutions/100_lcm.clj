(ns solutions.100-lcm)

; vararg version of mygcd
(def mygcd
  (letfn [(gcd2 [a b]
            (if (= 0 b)
              a
              (let [t1 b t2 (mod a b)]
                (gcd2 t1 t2))))]
    (fn gcd
      ([a] a)
      ([a & args]
       (gcd2 a (apply gcd args))))))

(def mylcm
  (letfn [(gcd2 [a b]
            (if (= 0 b)
              a
              (let [t1 b t2 (mod a b)]
                (gcd2 t1 t2))))
          (gcd
           ([a] a)
           ([a & args]
            (gcd2 a (apply gcd args))))]
    (fn [& args]
      (/ (reduce * args)
         (apply gcd args)))))

(mygcd 6 12 3)
(mylcm 1/3 2/5)
(mylcm 3/4 1/6)
(mylcm 2 7 5/7 3/5)

(/ (reduce * [1/3 2/5])
   (apply mygcd [1/3 2/5]))
;(def mylcm
  ;(fn lcm [a b]
    ;(letfn [(gcd [a b]
    ;(if (= 0 b)
      ;a
      ;(let [t1 b t2 (mod a b)]
        ;(gcd t1 t2))))]
