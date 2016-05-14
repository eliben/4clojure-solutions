(ns solutions.102-camelcase)

(def s "multi-word-key")
(map clojure.string/capitalize (clojure.string/split s #"-"))

(def camelcase
  (fn [s]
    (let [parts (clojure.string/split s #"-")]
      (if (<= (count parts) 2)
        s
        (clojure.string/join
         (cons (first parts)
               (map clojure.string/capitalize (rest parts))))))))

(camelcase s)
