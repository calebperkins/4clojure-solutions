(defn levenshtein [xs ys]
  ((memoize
    (fn lev [xs' ys']
      (cond
       (empty? xs') (count ys')
       (empty? ys') (count xs')
       :else (min
              (inc (levenshtein (rest xs') ys'))
              (inc (levenshtein xs' (rest ys')))
              (+
               (levenshtein (rest xs') (rest ys'))
               (if (= (first xs') (first ys')) 0 1))))))
   xs ys))

(defn leven
  ([xs ys] (leven xs ys {}))
  ([xs ys memo]
   (cond

       (empty? xs) (count ys)
       (empty? ys) (count xs)
       :else (min
              (inc (leven (rest xs) ys))
              (inc (leven xs (rest ys)))
              (+
               (leven (rest xs) (rest ys))
               (if (= (first xs) (first ys)) 0 1))))))

(defn compute-matrix [xs ys]
  (letfn []
    (reduce combine {}
            (for [i ()]))))


(+ 1 2)

(levenshtein "kitten" "sitting") ; 3

;(levenshtein "ttttattttctg" "tcaaccctaccat")
