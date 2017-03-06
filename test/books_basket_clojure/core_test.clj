(ns books-basket-clojure.core-test
  (:require [clojure.test :refer :all]
            [books-basket-clojure.core :refer :all]))

(def not-eligible-for-discount [{:theme :Beauty :price 5} {:theme :Education :price 7} {:theme :Love :price 9}])

(deftest total-of-a-books-basket
  (testing "given an empty basket should return zero"
    (is (= 0 (gross [])))
    )

  (testing "given a basket full of boot not eligible for a discount should return the sum of every book price"
    (is (= 21 (gross not-eligible-for-discount)))
    )

  (testing "given a basket full of boot not eligible for a discount should return the sum of every book price"
    (is (= 21 (gross not-eligible-for-discount)))
    )
  )


