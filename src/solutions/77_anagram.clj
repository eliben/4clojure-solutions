(ns solutions.77-anagram)

(defn sign [s]
  (clojure.string/join "" (sort (clojure.string/split s #""))))

(def wordlist ["veer" "lake" "item" "kale" "mite" "ever"])

(def anagrams
  (fn [wordlist]
    (letfn [(sign [s]
              (clojure.string/join "" (sort (clojure.string/split s #""))))]
      (set (filter (fn [st] (> (count st) 1))
                   (map #(set (second %)) (group-by sign wordlist)))))))

(anagrams wordlist)

(anagrams ["meat" "mat" "team" "mate" "eat"])
