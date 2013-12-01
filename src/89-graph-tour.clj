; http://en.wikipedia.org/wiki/Eulerian_path
; An undirected graph has an Eulerian trail if and only if at most two vertices
; have odd degree, and if all of its vertices with nonzero degree belong to a
; single connected component.
(defn traversable? [edges]
  (let [vertices (set (flatten edges))
        g (reduce
           (fn [m [a b]]
            (assoc m
             a (conj (m a #{}) b)
             b (conj (m b #{}) a)))
           {}
           edges)]
    (and
     (->> edges flatten frequencies vals (filter odd?) count (>= 2))
     (loop [L #{(first vertices)}
            K [(first vertices)]]
      (if (empty? K)
       (= L vertices)
       (let [y (peek K)
             K' (pop K)
             unexplored (clojure.set/difference (g y) L)]
        (recur
         (into L unexplored)
         (into K' unexplored))))))))


; tests
(= true (traversable? [[:a :b]]))
(= false (traversable? [[:a :a] [:b :b]]))
(= false (traversable? [[:a :b] [:a :b] [:a :c] [:c :a]
               [:a :d] [:b :d] [:c :d]]))
(= true (traversable? [[1 2] [2 3] [3 4] [4 1]]))
(= true (traversable? [[:a :b] [:a :c] [:c :b] [:a :e]
              [:b :e] [:a :d] [:b :d] [:c :e]
              [:d :e] [:c :f] [:d :f]]))
(= false (traversable? [[1 2] [2 3] [2 4] [2 5]]))
