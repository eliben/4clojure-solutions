(ns solutions.195-parentheses)

;--- Meh, this approach doesn't generate them all
;(def gen
  ;(fn gen [n]
    ;(letfn [(combine-pre [s]
              ;(set (map #(str "()" %) s)))
            ;(combine-post [s]
              ;(set (map #(str % "()") s)))
            ;(combine-in [s]
              ;(set (map #(str "(" % ")") s)))]
      ;(cond 
        ;(= n 0) #{""}
        ;(= n 1) #{"()"}
        ;:else
        ;(let [prev (gen (- n 1))]
          ;(clojure.set/union (combine-pre prev)
                             ;(combine-post prev)
                             ;(combine-in prev)))))))

(def gen
  (fn gen
    [n]
    (letfn [(genlr [l r]
              (cond
                (and (= l 0) (= r 0)) #{""}
                :else (let [wl (if (> l 0)
                                 (set (map #(str "(" %) (genlr (- l 1) r)))
                                 #{})
                            wr (if (> r l)
                                 (set (map #(str ")" %) (genlr l (- r 1))))
                                 #{})]
                        (clojure.set/union wl wr))))]
      (genlr n n))))

;(gen 1) (gen 2 2)
(gen 3)
;(gen 0)
(dotimes [n 11] (println (count (gen n))))
;(gen 0)
;(gen 1)
;(gen 2)
;(gen 3)
;(gen 4)
;(count (gen 10))
