(ns solutions.128-cards)

(def mycards
  (fn [s]
    (let [suitmap {\D :diamond,
                   \H :heart,
                   \S :spade,
                   \C :club}
          rankmap {\2 0,
                   \3 1,
                   \4 2,
                   \5 3,
                   \6 4,
                   \7 5,
                   \8 6,
                   \9 7,
                   \T 8,
                   \J 9,
                   \Q 10,
                   \K 11,
                   \A 12}]
      {:suit (get suitmap (first s)),
       :rank (get rankmap (second s))})))

(mycards "D5")
(mycards "SJ")

(get {\D :diamond, \H :heart} \D)
