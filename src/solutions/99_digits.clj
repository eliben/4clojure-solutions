(ns solutions.99-digits)

(mod 981 10)

; This won't do since / gives us rational division
(mod (/ 981 10) 10)

; using quot instead
(mod (quot 981 10) 10)

(def digits
  (fn [n]
    (if (= 0 n)
      '()
      (cons (mod n 10)
            (lazy-seq (digits (quot n 10)))))))

(def mydigits
  (fn [a b]
    (letfn [(digits [n]
              (if (= 0 n)
                '()
                (cons (mod n 10)
                      (lazy-seq (digits (quot n 10))))))]
      (reverse (digits (* a b))))))

(reverse (digits (* 99 9)))
;(digits 981)
(mydigits 1 1)
(mydigits 99 9)
(mydigits 999 99)
