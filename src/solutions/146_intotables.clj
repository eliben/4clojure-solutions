(ns solutions.146-intotables)

; Playing with nested maps and 'for'
(def m1 '{a {p 1, q 2}
          b {m 3, n 4}})

; Silly way to get all values in the map
(for [[k v] m1] v)

; ... Now values in a nested map...
(for [[k1 v] m1
      [k2 v2] v]
  v2)

(into {}
      (for [[k1 v] m1
            [k2 v2] v]
        {[k1 k2] v2}))
