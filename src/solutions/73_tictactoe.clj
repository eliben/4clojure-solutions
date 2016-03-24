(ns solutions.73-tictactoe)

(def xwin1 [[:x :x :o]
            [:o :x :e]
            [:x :e :x]])

(def draw1 [[:x :e :o]
            [:x :x :e]
            [:o :x :o]])

(def owin1 [[:x :e :o]
            [:x :o :e]
            [:o :e :x]])

(defn allcomb
  "All combinations of elements from two sequences sa and sb.
  For (allcomb [1 2] [4 5]) would produce (1 4) (1 5) (2 4) (2 5)."
  [sa sb]
  (if (empty? sa)
    '()
    (concat (partition 2 (interleave (repeat (first sa)) sb))
            (allcomb (rest sa) sb))))

(def nums '(0 1 2))

(defn boardruns
  [n]
  (let [nr (range n)]
    (concat
     (list (map list nr nr))            ; main diagonal
     (list (map list nr (reverse nr)))  ; inverse diagonal
     (partition n (allcomb nr nr))
     (partition n (map reverse (allcomb nr nr))))))

(defn runwonby?
  [run side]
  (empty? (filter #(not= side %) run)))

; Works on arbitrary square NxN boards.
(def mytic
  (fn [board]
    (letfn [(allcomb [sa sb]
              (if (empty? sa)
                '()
                (concat (partition 2 (interleave (repeat (first sa)) sb))
                        (allcomb (rest sa) sb))))
            (boardruns [n]
                       (let [nr (range n)]
                         (concat
                          (list (map list nr nr))            ; main diagonal
                          (list (map list nr (reverse nr)))  ; inverse diagonal
                          (partition n (allcomb nr nr))
                          (partition n (map reverse (allcomb nr nr))))))
            (runwonby? [run side]
                       (empty? (filter #(not= side %) run)))]
      (let [n (count board)
            allruns (map #(map (partial get-in board) %) (boardruns n))
            x-won (some #(runwonby? % :x) allruns)
            o-won (some #(runwonby? % :o) allruns)]
        (cond
          x-won :x
          o-won :o
          :else nil)))))

; ------------- playground ---------------


(mytic draw1)
(mytic owin1)
(mytic xwin1)

(def firstrun (map (partial get-in xwin1)
                   (first (boardruns (count xwin1)))))

(def allruns (map (fn [r] (map (partial get-in xwin1) r))
                  (boardruns (count xwin1))))
(prn allruns)
(some #(runwonby? % :o) allruns)

(partition 3 (allcomb '(0 1 2) nums))

(partition 3 (map reverse (allcomb '(0 1 2) nums)))

(partition 2 (interleave [1 2 3] [4 5 6]))
(concat '(1 2 3) '(4 5 6))

(allcomb '(1 2 3) '(4 5 6))
(allcomb '(0 1 2) '(0 1 2))
(allcomb '(0) '(0 1 2))

(get-in owin1 '(0 1))
((partial get-in owin1) '(0 1))
