(defn foo
  ([f xs] (foo f (first xs) (rest xs)))
  ([f acc xs] (if (empty? xs)
                [acc]
                (cons acc (lazy-seq (foo f (f acc (first xs)) (rest xs)))))))