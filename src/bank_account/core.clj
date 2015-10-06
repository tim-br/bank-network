(ns bank-account.core)

(def my-bank-account (atom 0))

(def bank-accounts (atom {}))

(def countre (atom 0))

(defn withdraw [amount bank-atom]
  (swap! bank-atom #(- % amount)))

(defn deposit [amount bank-atom]
  (swap! bank-atom #(+ % amount)))

(defn add-new-account
  [account-map]
  (println "in add account functoin"))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
