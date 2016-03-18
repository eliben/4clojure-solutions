(ns solutions.46-flipout)

; Higher-order function: takes a function as argument, returns another function
; that applies func's arguments in reverse.
(def myflipout
  (fn [func]
    (fn [& args]
      (apply func (reverse args)))))

((myflipout nth) 2 [1 2 3 4 5])
    
