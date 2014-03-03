(comp first (partial reduce
          (fn [[best current] n]
            (if (empty? current)
              [best [n]]
              (if (= n (inc (last current)))
                (let [current' (conj current n)]
                  (if (> (count current') (count best))
                    [current' current']
                    [best current']))
                [best [n]])))
          [[], []]))
