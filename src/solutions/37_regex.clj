(ns solutions.37-regex)

; re-seq provides a sequence of successive matches, so the following splits the
; string to a sequence of non-whitespace words.
(re-seq #"\w+" "mary had a little lamb")

; (apply str ...) can be used to fuse the matches into a single string.
(apply str (re-seq #"[A-Z]+" "bA1B3Ce "))
