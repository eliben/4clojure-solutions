(ns solutions.78-trampoline)

(def mytrampoline
  (fn [f & args]
    (let [v1 (apply f args)]
      (loop [v v1]
        (if (fn? v)
          (recur (apply v '()))
          v)))))

(defn foo [x]
   (if (< x 0)
     (println "done")
     #(foo (do (println :x x) (dec x)))))

(mytrampoline foo 5)

