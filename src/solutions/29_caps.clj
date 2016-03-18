(ns solutions.29-caps)

; Character/isUpperCase checks for upper-case

(Character/isUpperCase \H)
(filter #(Character/isUpperCase %) "fooBAr")

(def mycaps
  (fn [s]
    (apply str (filter #(Character/isUpperCase %) s))))

(mycaps "HelO, DuuDez!!")
