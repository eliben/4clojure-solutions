(ns solutions.122-readbinary)

(def binstr "1011")

(reverse (seq binstr))

(def readbinary
  (fn [s]
    (let [charseq (reverse (seq s))]
      (loop [crs charseq result 0 factor 1]
        (if (seq crs)
          (recur (rest crs)
                 (+ result (* factor (if (= (first crs) \1) 1 0)))
                 (* factor 2))
          result)))))

(readbinary "0")
(readbinary "1")

