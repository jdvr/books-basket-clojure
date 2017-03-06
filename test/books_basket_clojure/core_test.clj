(ns books-basket-clojure.core-test
  (:require [clojure.test :refer :all]
            [books-basket-clojure.core :refer :all]))

(def not-eligible-for-discount [{:theme :Beauty :price 5} {:theme :Education :price 7} {:theme :Love :price 9}])
(def all-eligible-for-discount [{:theme :Fantasy :price 10} {:theme :IT :price 10}])

(deftest gross-of-a-books-basket
  (testing "given an empty basket should return zero"
    (is (= 0 (gross [])))
    )

  (testing "given a basket full of book not eligible for a discount should return the sum of every book price"
    (is (= 21 (gross not-eligible-for-discount)))
    )

  (testing "given a basket full of book with a discount should return the sum of every book price"
    (is (= 21 (gross all-eligible-for-discount)))
    )
  )


(deftest net-of-a-books-basket
  (testing "given an empty basket should return zero"
    (is (= 0 (net [])))
    )

  (testing "given a basket full of book eligible for a discount should return the sum of every book price"
    (is (= 21 (net not-eligible-for-discount)))
    )


  (testing "given a basket full of book eligible for a discount should return the sum of every book price"
    (is (= 17 (net all-eligible-for-discount)))
    )


  )



