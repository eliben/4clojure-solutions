(ns solutions.60-reductions)

(def s [1 2 3 4 5 6])

(defn adder
  [accum v]
  (+ accum v))

(reduce adder s)
(reductions adder 0 s)

; This solution works OK but it's eager so it won't work with infinite coll - it
; collects the whole result before returning it.
(def myreductions
  (fn mr
    ([func coll]
     (mr func (func) coll))
    ([func init coll]
     (loop [c coll
            result [init]]
       (if (empty? c)
         result
         (let [newval (func (last result) (first c))]
           (recur (rest c) (conj result newval))))))))

(myreductions adder 0 s)
;(myreductions + s)
(myreductions + (range 10))

; A lazy version that uses recursion.
(def lazyreductions
  (fn lr
    ([func coll]
     (lr func
         (if (empty? coll) (func) (first coll))
         (rest coll)))
    ([func init coll]
     (println init (first coll))
     (if (empty? coll)
       (list init)
       (lazy-seq
        (cons init
              (lr func (func init (first coll)) (rest coll))))))))

(lazyreductions adder 0 s)
(take 5 (lazyreductions + (range)))
(take 5 (reductions + (range)))
(lazyreductions conj [1] [2 3 4])
(last (lazyreductions * 2 [3 4 5]))
