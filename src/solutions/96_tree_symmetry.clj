(ns solutions.96-tree-symmetry)

(def ismirror
  (fn ismirror
    ([t]
     (ismirror (second t) (last t)))
    ([t1 t2]
     (cond
       (and (nil? t1) (nil? t2)) true
       (or (nil? t1) (nil? t2)) false
       :else
       (and (= (first t1) (first t2))
            (ismirror (second t1) (last t2))
            (ismirror (last t1) (second t2)))))))

(ismirror
 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
 [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil])

(ismirror
 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
 [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil])
