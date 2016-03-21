(ns solutions.63-groupby)

(def mp {:name "foo" :age 22})

; Various ways to update values in a hashmap.
(assoc mp :name "sdf")
(update mp :name #(str "ahoy-" %)) 

(update
 (update mp :bado #(conj (if (mp %) (conj % 1) [1])))
 :bado
 #(conj % 2))

; 4clojure doesn't support 'update', so roll my own inside
(def mygroupby
  (fn [func coll]
    (loop [c coll m {}]
      (println c m)
      (if (empty? c) 
        m
        (let [v (first c) mapkey (func v)]
          (recur (rest c)
                 (assoc m mapkey
                        (if (nil? (get m mapkey))
                          [v]
                          (conj (get m mapkey) v)))))))))

(mygroupby #(> % 5) [1 3 6 8])
(mygroupby #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
