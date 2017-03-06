(ns books-basket-clojure.core
  (:gen-class))

(def discounts-by-theme {
  :Fantasy (fn [price] (- price (* 0.2 price)))
  :IT (fn [price] (- price (* 0.1 price)))
})

(defn price-with-discount [{theme :theme price :price}]
  ((get discounts-by-theme theme identity) price))

(defn net [books]
  (reduce + 0 (map price-with-discount books)))


(defn gross [books]
  (reduce + 0 (map :price books)))
