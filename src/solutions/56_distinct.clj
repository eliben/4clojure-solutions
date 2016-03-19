(ns solutions.56-distinct)

; Create a set with a literal
(def s #{1 2 3})

; Add item to set
(def news (conj s :kwa))

; Check if :kwa is in news. Since :kwa is a keyword, it can come first. This
; won't work for numbers, though.
(:kwa news)
(news :kwa)
(news 5)
(news 2)

(def mydistinct
  (fn [coll]
    (loop [c coll seen #{} clean []]
      (cond
        (empty? c) clean
        (seen (first c)) (recur (rest c) seen clean)
        :else (recur (rest c) (conj seen (first c)) (conj clean (first c)))))))

(mydistinct [1 2 1 3 1 2 4])
