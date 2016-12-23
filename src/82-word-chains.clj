
; dot and do
(defn chainable? [x y]
  (let [longer (if (> (count x) (count y)) x y)
        shorter (if (= longer x) y x)
        non-match (first (first (filter (partial apply not=) (map vector longer (str shorter " ")))))]
    (or
     (and (= (count x) (count y))
          (->> (map vector x y)
               (filter (partial apply not=))
               count
               (>= 1)))
     (= longer (str shorter (last longer)))
     (= longer (str (first longer) shorter))
     (= shorter (clojure.string/replace-first longer non-match "")))))



(defn word-chain? [words]
  (<= (count words)
     (count (filter (partial apply chainable?)
             (set (for [x words y words :when (not= x y)]
                    (set [x y])))))))


(defn word-chain? [words]
  (<= (count words)
      (count (filter (fn [[x y]]
                       (let [longer (if (> (count x) (count y)) x y)
                             shorter (if (= longer x) y x)
                             non-match (first (first (filter (partial apply not=) (map vector longer (str shorter " ")))))]
                         (or
                          (and (= (count x) (count y))
                               (->> (map vector x y)
                                    (filter (partial apply not=))
                                    count
                                    (>= 1)))
                          (= longer (str shorter (last longer)))
                          (= longer (str (first longer) shorter))
                          (= shorter (clojure.string/replace-first longer non-match "")))))
                     (for [x words y words :when (neg? (compare x y))]
                            [x y])))))
