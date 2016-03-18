(ns solutions.39-interleave)

; using map on two sequences
(map #(list %1 %2) [1 2 3] [4 5 6])

(mapcat #(list %1 %2) [1 3] [4 5 6])

