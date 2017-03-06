(ns books-basket-clojure.core
  (:gen-class))



(defn net [books]
  (reduce + 0 (map :price books)))


(defn gross [books]
  (reduce + 0 (map :price books)))
