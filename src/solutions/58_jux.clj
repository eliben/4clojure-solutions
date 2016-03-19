(ns solutions.58-jux)

(def myjux
  (fn [& funcs]
    (fn [& args]
      (map #(apply % args) funcs))))

((myjux + max min) 2 3 5 1 6 4)
((myjux #(.toUpperCase %) count) "hello")
((myjux :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10})
