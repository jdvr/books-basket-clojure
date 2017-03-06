(ns books-basket-clojure.core-test
  (:require [clojure.test :refer :all]
            [books-basket-clojure.core :refer :all]))

(def not-eligible-for-discount [{:theme :Beauty :price 5} {:theme :Education :price 7} {:theme :Love :price 9}])
(def all-eligible-for-discount [{:theme :Fantasy :price 10} {:theme :IT :price 10}])
(def it-books-for-discount [{:theme :IT :price 10} {:theme :IT :price 20} {:theme :IT :price 30}])

(deftest gross-of-a-books-basket
  (testing "given an empty basket should return zero"
    (is (= 0 (gross [])))
    )

  (testing "given a basket full of book not eligible for a discount should return the sum of every book price"
    (is (= 21 (gross not-eligible-for-discount)))
    )

  (testing "given a basket full of book with a discount should return the sum of every book price"
    (is (= 20 (gross all-eligible-for-discount)))
    )
  )


(deftest net-of-a-books-basket
  (testing "given an empty basket should return zero"
    (is (= 0 (net [])))
    )

  (testing "given a basket full of book eligible for a discount should return the sum of every book price after applying the discount"
    (is (= 17.0 (net all-eligible-for-discount)))
    )

  (testing "given a basket with three IT books should return the sum of every book price after applying a 30% to each price"
    (is (= 42.0 (net it-books-for-discount)))
    )


  )



