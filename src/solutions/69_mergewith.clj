(ns solutions.69-mergewith)

(def mymergewith
  (fn _mymergewith
    ([func m1 m2 & maps]
     ; Take care of more than two maps
     (_mymergewith
       func m1 (apply _mymergewith func m2 (first maps) (rest maps))))
    ([func m1 m2]
     (loop [result m1 m2part m2]
       (if (empty? m2part)
         result
         (let [[k v] (first m2part)
               resultval (get result k)]
           (if (nil? resultval)
             (recur (assoc result k v) (rest m2part))
             (recur (assoc result k (func resultval v)) (rest m2part)))))))))


(mymergewith * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
