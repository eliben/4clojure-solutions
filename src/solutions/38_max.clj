(ns solutions.38-max)

(def mymax
  (fn [coll]
    (loop [c coll cur_max (first coll)]
      (if (empty? c)
        cur_max
        (recur (rest c)
               (if (> (first c) cur_max) (first c) cur_max))))))


(def mymax2
  (fn [coll]
    (reduce (fn [acc val] (if (> acc val) acc val)) coll)))


(def mymax2-on-args
  (fn [& coll]
    (reduce (fn [acc val] (if (> acc val) acc val)) coll)))


(mymax2 [1 8 3 5])
(mymax2 [30 20])
(mymax2 [34 67 11])
(mymax2-on-args 34 67 11)
