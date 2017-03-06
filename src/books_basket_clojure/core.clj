(ns books-basket-clojure.core
  (:gen-class))



(defn gross [books]
  (reduce + 0 (map :price books)))
