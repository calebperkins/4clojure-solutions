(def digits (range 10))
(defn to-int [s] (Integer/parseInt s))


(defn palindromes [n]
  (if (< n 10)
    (lazy-cat (range n 10) (palindromes 10))
     (to-int (apply str (map (fn [n] (apply str [n n])) digits)))))
