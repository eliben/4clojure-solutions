(ns solutions.62-iterate)

(def myiterate
  (fn iter
    ([func init]
     (lazy-seq
      (cons init (iter func (func init)))))))

(take 5 (myiterate inc 0))
