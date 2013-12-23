(fn [{start :start accepts :accepts trans :transitions}]
  ((fn helper [word state]
     (let [transitions (trans state)
           next-states (map (fn [[sym state']] [(str word sym) state']) transitions)
           accept-states (filter #(accepts (second %)) next-states)
           results (map first accept-states)
           remaining (mapcat #(lazy-seq (apply helper %)) next-states)]
       (lazy-cat results remaining))) "" start))
