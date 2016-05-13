(ns solutions.76-trampoline-intro)

(defn foo [x]
   (if (< x 0)
     (println "done")
     #(foo (do (println :x x) (dec x)))))

; will call foo as long as it returns a function.
(trampoline foo 5)
