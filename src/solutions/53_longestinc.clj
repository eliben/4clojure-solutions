(ns solutions.53-longestinc)

(def mylis
  (fn [coll]
    (loop [c (rest coll) cur-IS [(first coll)] longest-IS []]
      ;(println c cur-IS longest-IS)
      (if (empty? c)
        longest-IS
        ; Invariants:
        ; c is the remains of the input collection we're looking at.
        ; cur-IS is the current increasing subsequence.
        ; longest-IS is the longest increasing subsequence we've seen so far.
        (let [cur-item (first c)
              last-seen (last cur-IS)]
          (if (or (nil? last-seen) (= cur-item (inc last-seen)))
            ; Now cur-IS is one longer, but check if it should be passed as
            ; longest-IS as well.
            (if (>= (count cur-IS) (count longest-IS))
              (recur (rest c) (conj cur-IS cur-item) (conj cur-IS cur-item))
              (recur (rest c) (conj cur-IS cur-item) longest-IS))
            ; Not increasing, so reset cur-IS.
            (recur (rest c) [cur-item] longest-IS)))))))

(mylis [1 0 1 2 3 0 4 5])
(mylis [5 6 1 3 2 7 8 9])
