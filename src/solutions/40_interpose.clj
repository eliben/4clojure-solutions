(ns solutions.40-interpose)

(reduce #(conj %1 "," %2) [] [1 2 3 4])

(def myinterpose
  (fn [delim coll]
    (rest (reduce #(conj %1 delim %2) [] coll))))

(myinterpose 0 [1 2 3])
(apply str (myinterpose ", " ["one" "two" "three"]))
