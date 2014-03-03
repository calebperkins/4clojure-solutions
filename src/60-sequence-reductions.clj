(defn intermediate-reduce
  ([f initial s]
   (if (empty? s)
     [initial]
     (conj (lazy-seq (intermediate-reduce f (f initial (first s)) (rest s))) (f initial (first s)))))
  ([f s]
   (intermediate-reduce f (first s) (rest s))))


(+ 1 3 2 1)
 ; tests
 (= (take 5 (intermediate-reduce + (range))) [0 1 3 6 10])
 ;(= (intermediate-reduce conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
 ;(= (last (intermediate-reduce * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
