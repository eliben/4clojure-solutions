(ns solutions.83-halftruth)

(def lst '(true true false))
(every? identity lst)
(some identity lst)

(def myht
  (fn [& s]
    (if (and (some identity s)
             (not (every? identity s)))
      true
      false)))

(myht false false)
(myht true false)
(myht true true)
