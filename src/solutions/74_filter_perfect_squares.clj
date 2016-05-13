(ns solutions.74-filter-perfect-squares)

(def nums "4,5,6,7,8,9")
(def nums "16,25,36")

; split a string by comma
(clojure.string/split nums #",")

; ... and convert them to actual ints; wrapping in #(...) because Java methods
; are not Clojure functions.
(map #(Integer/parseInt %) (clojure.string/split nums #","))

; Find the squares...
(clojure.string/join
 ","
 (filter
  (fn [s]
    (let [n (Integer/parseInt s)
          root (Math/sqrt n)]
      (= (* root root) (float n))))
  (clojure.string/split nums #",")))
