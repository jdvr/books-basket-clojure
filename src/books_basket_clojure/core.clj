(ns books-basket-clojure.core
  (:gen-class))



(defn total [books]
  (reduce + 0 (map :price books)))
