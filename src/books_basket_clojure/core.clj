(ns books-basket-clojure.core
  (:gen-class))

(def discounts-by-theme {
  :Fantasy (fn [price size] (- price (* 0.2 price)))
  :IT (fn [price size]
        (if (> size 2)
          (- price (* 0.3 price))
          (- price (* 0.1 price)))
        )
  :Travel (fn [price size]
        (if (> size 3)
          (- price (* 0.4 price))
          price)
        )
})

(defn not-discount-theme [price size] price)

(defn- price-with-discount [theme price size]
  ((get discounts-by-theme theme not-discount-theme) price size))

(defn- total-by-theme [books theme]
  (count (map theme books)))

(defn net [books]
  (reduce + 0 (map (fn [{theme :theme price :price}]
                     (price-with-discount theme price (total-by-theme books theme)) ) books)))


(defn gross [books]
  (reduce + 0 (map :price books)))
