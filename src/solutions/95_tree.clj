(ns solutions.95-tree)

(def myistree
  (fn self_ [triple]
    (if (nil? triple)
      true
      (if (and (coll? triple) (= (count triple) 3))
        (let [value (first triple)
              left (second triple)
              right (last triple)]
          (and (self_ left) (self_ right)))
        false))))

(myistree '(:a (:b nil nil) nil))
(myistree '(:a (:b nil nil)))
