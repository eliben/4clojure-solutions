(ns solutions.64-blackbox)

; Only maps support assoc with non-integer keys.
(def myismap
  (fn [x]
    (try
      (assoc x :bobo :koko)
      true
      (catch Exception e false))))

; I had a beautiful plan to use catch for maps, but 4Clojure doesn't allow catch
; - without notice... BOO!! They have a Github issue open for this but no one
; fixes it :-/
(def myismapnocatch
  (fn [x]
    (let [newx (conj x [:kookoo :booboo])]
      (not (nil? (get newx :kookoo nil))))))

(def findorder
  (fn [x]
    ; plug in the hacky map-detector
    (let [newx (conj x [:kookoo :booboo])]
      (if (not (nil? (get newx :kookoo nil)))
        :map
        ; otherwise check order of conj
        (let [s [100 500 200 600]
              bigger (apply (partial conj x) s)
              asvec (into [] bigger)]
          (cond (= (reverse (take 4 asvec)) s) :list
                (= (take-last 4 asvec) s) :vector
                :else :set))))))

(map myismapnocatch [#{} {} [] '()])

;(myisset #{8 9}) (myisset [8 9])
;(myisset '(8 9))

(findorder '(1 2 3))
(findorder [1 2 3])
(findorder #{1 2 3})
(findorder {:kwa 4})
;(map findorder [#{} [] ()])

;(myismap #{})
;(try
     ;(assoc [] :b k
