(fn [pred value coll]
  (if (empty? coll) []
    (->> (partition 2 (interleave coll (rest coll)))
       (mapcat (fn [[a b]] (if (pred a b) [value b] [b])))
       (cons (first coll)))))
