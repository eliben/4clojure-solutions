(ns solutions.57-comp)

(def mycomp
  (fn mc
    ([f1 f2]
     (fn [& args]
       (f1 (apply f2 args))))
    ([f1 f2 & fs]
     (mc f1 (apply mc f2 fs)))))

((mycomp rest rest reverse) [1 2 3 4])
