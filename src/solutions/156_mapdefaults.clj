(ns solutions.156-mapdefaults)

(into {} [[:a 0] [:b 0]])

(into {}
      (map #(vector % 0) '(1 2 3 4)))

(def mymapdefaults
  (fn [default keys]
    (into {} (map #(vector % default) keys))))

(mymapdefaults 0 [:a :b :c])
