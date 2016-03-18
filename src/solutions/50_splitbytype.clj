(ns solutions.50-splitbytype)

(group-by class [:a 4 8 9 :b 6])

(def mysplitbytype
  (fn [coll]
    (vals (group-by class coll))))

(mysplitbytype [:a "foo"  "bar" :b])
