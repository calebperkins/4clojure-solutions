; sum of products
; http://en.wikipedia.org/wiki/K_map



;'a 'B 'C 'd
;'A 'b 'c 'd
;'A 'b 'c 'D
;'A 'b 'C 'd
;'A 'b 'C 'D
;'A 'B 'c 'd
;'A 'B 'c 'D
;'A 'B 'C 'd

; each group has one difference between rows. each group is a product

'a 'B 'C 'd
'A 'B 'C 'd
'A 'b 'C 'd
'A 'b 'C 'D

'A 'b 'c 'd
'A 'b 'c 'D

'A 'B 'c 'd
'A 'B 'c 'D

; then do variability analysis.. for group 2 and 3 D does not matter so take it out
; then tak out B. you are left with Ac, which is a product

; a seq of rows that output 1 in the truth table, sorted
(defn minterms [sop])

(defn flatten-sets
  "Like flatten, but pulls elements out of sets instead of sequences."
  [v]
  (filter (complement set?)
          (rest (tree-seq set? seq (set v)))))

; number of input variables
(defn vars [sop]
  (count (set (map clojure.string/capitalize (flatten-sets sop)))))

(defn veitch [sop]
  ())