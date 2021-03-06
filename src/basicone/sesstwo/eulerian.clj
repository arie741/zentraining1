;; Do Euler Number 1 & 2 with Loop Recursion

;;;;;;;;;;;;;;;;;;; Number 1 ;;;;;;;;;;;;;;;;;;;

; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
;The sum of these multiples is 23.
; Find the sum of all the multiples of 3 or 5 below 1000.

(defn multiples
  [coll]
  (loop [[x & xs] coll res 0]
    (if x (if (or (= 0 (rem x 3)) (= 0 (rem x 5))) 
            (recur xs (+ res x))
            (recur xs (+ res 0)))
      res)))

;;;;;;;;;;;;;;;;;;; Number 2 ;;;;;;;;;;;;;;;;;;;
; Each new term in the Fibonacci sequence is generated by adding the previous two terms. 
; By starting with 1 and 2, the first 10 terms will be: (1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...)
; By considering the terms in the Fibonacci sequence whose values do not exceed four million, 
; find the sum of the even-valued terms.


(defn fibbo
  [num]
  (loop [n num a 1 b 2 res [1 2]]
    (if (= n 2) res
      (recur (dec n) b (+ a b) (conj res (+ a b))))))

(defn max-value
  [n]
  (if (>= (last (fibbo n)) 4000000)
    (dec n)
    (max-value (inc n))))

(apply + (filter even? (fibbo (max-value 2))))
  
