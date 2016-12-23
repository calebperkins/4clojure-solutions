(defn partial-flatten [form]
  (clojure.walk/postwalk
   #(if (and (sequential? %) (sequential? (first %))) )
   form))

; get-in

;  (= '((1 1) 2 3) [[1 1] 2 3])

; sequential?

; final result is [ [item] ] === an item inside seq inside seq

; clojure.walk/postwalk

(= (partial-flatten [["Do"] ["Nothing"]])
   [["Do"] ["Nothing"]])

(= (partial-flatten [[[[:a :b]]] [[:c :d]] [:e :f]])
   [[:a :b] [:c :d] [:e :f]])

(= (partial-flatten '((1 2)((3 4)((((5 6)))))))
   '((1 2)(3 4)(5 6)))