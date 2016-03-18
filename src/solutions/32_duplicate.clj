(ns solutions.32-duplicate)

(mapcat #(list % %) '(1 2 3 4 5))

(#(interleave % %) '(1 2 3 4 5))
